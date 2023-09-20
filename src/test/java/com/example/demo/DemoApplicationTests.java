package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class DemoApplicationTests {


	Calculator calculator = new Calculator();
	@Test
	void contextLoads() {

		// given
		int firstNum = 5;
		int secondNum = 5;

		// When
		int result = calculator.add(firstNum, secondNum);

		// then
		assertThat(result).isEqualTo(11);
	}

	class Calculator  {
		int add (int a, int b) {
			return a + b;
		}
	}
}
