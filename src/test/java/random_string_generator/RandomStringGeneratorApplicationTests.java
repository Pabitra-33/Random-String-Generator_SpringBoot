package random_string_generator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import random_string_generator.service.RandomStringService;

@SpringBootTest
class RandomStringGeneratorApplicationTests {

	private final RandomStringService service = new RandomStringService();

	@Test
	void testGenerateRandomStringDefault() {
		String result = service.generateRandomString(10, "alphanumeric");
		assertNotNull(result);
		assertEquals(10, result.length());
	}

	@Test
	void testGenerateRandomStringLettersOnly() {
		String result = service.generateRandomString(8, "letters");
		assertTrue(result.matches("[A-Za-z]+"));
	}

	@Test
	void testGenerateRandomStringNumbersOnly() {
		String result = service.generateRandomString(6, "numbers");
		assertTrue(result.matches("[0-9]+"));
	}

	@Test
	void testInvalidLength() {
		Exception ex = assertThrows(RuntimeException.class, () -> service.generateRandomString(0, "alphanumeric"));
		assertEquals("Length must be between 1 and 100", ex.getMessage());
	}
}