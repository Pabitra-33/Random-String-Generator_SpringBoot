package random_string_generator.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import random_string_generator.exception.InvalidInputException;

@Service
public class RandomStringService {

	private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SYMBOLS = "!@#$%^&*()-_=+<>?";

	private final SecureRandom random = new SecureRandom();

	public String generateRandomString(int length, String type) {
		if (length <= 0 || length > 100) {
			throw new InvalidInputException("Length must be between 1 and 100");
		}

		String characters = switch (type.toLowerCase()) {
		case "letters" -> ALPHABET;
		case "numbers" -> NUMBERS;
		case "symbols" -> SYMBOLS;
		case "alphanumeric" -> ALPHABET + NUMBERS;
		case "all" -> ALPHABET + NUMBERS + SYMBOLS;
		default -> throw new InvalidInputException("Invalid type: " + type);
		};

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			sb.append(characters.charAt(random.nextInt(characters.length())));
		}
		return sb.toString();
	}
}