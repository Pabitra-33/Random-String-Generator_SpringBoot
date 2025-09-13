package random_string_generator.dto;

import lombok.Data;

@Data
public class RandomStringRequest {

	//used the lombok for auto getter and setter and also for constructors
	private int length;
	private String type;
}