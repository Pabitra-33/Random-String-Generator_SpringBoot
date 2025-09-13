package random_string_generator.dto;

import lombok.Data;

@Data
public class RandomStringRequest {

	//used the Lombok for auto getter and setter and also for constructors.
	//dto used for transferring the data.
	private int length;
	private String type;
}