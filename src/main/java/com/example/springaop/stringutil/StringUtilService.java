package com.example.springaop.stringutil;

import org.springframework.stereotype.Service;

@Service
public class StringUtilService {
	public String reverseString(String target) {
		return new StringBuilder(target).reverse().toString();
	}

	public String capitalizeAllLetters(String target) {
		if (target == null) {
			throw new IllegalStateException("String must not be null");
		}

		return target.toUpperCase();
	}

	public String removeAllWhitespaces(String target) {
		return target.replaceAll("\\s+", "");
	}

	public String removeAllNumbers(String target) {
		if (target == null) {
			throw new IllegalStateException("String must not be null");
		}

		return target.replaceAll("\\d", "");
	}
}
