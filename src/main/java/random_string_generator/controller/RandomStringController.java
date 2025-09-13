package random_string_generator.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import random_string_generator.dto.RandomStringRequest;
import random_string_generator.service.RandomStringService;

@RestController
@RequestMapping("/api")
@Tag(name = "Random String API", description = "Endpoints for generating random strings")
public class RandomStringController {

	@Autowired
	private final RandomStringService randomStringService;

	//constructor injection
	public RandomStringController(RandomStringService randomStringService) {
		this.randomStringService = randomStringService;
	}

	@GetMapping("/randomString")
	@Operation(summary = "Generate Random String (GET)", description = "Generate using query params")
	public Map<String, String> getRandomString(@RequestParam(defaultValue = "10") int length,
			@RequestParam(defaultValue = "alphanumeric") String type) {

		String result = randomStringService.generateRandomString(length, type);
		Map<String, String> response = new HashMap<>();
		response.put("length", String.valueOf(length));
		response.put("type", type);
		response.put("randomString", result);
		return response;
	}

	@PostMapping("/randomString")
	@Operation(summary = "Generate Random String (POST)", description = "Generate using JSON body")
	public Map<String, String> getRandomStringPost(@RequestBody RandomStringRequest request) {
		String result = randomStringService.generateRandomString(request.getLength(), request.getType());
		Map<String, String> response = new HashMap<>();
		response.put("length", String.valueOf(request.getLength()));
		response.put("type", request.getType());
		response.put("randomString", result);
		return response;
	}
}