package com.example.demo;

import com.example.demo.Product.Product;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	public void productTest() {
		Product EXPECTED = new Product(42L, "LG Monitor", "32 inches, 4K Resolution, Ideal for programmers", true, new BigDecimal("429.99"), 77);
		Product TO_BE_TESTED = new Product(-1L, "LG Monitor", "dummy value: whatever", true, new BigDecimal("429.99"), 77);
		assertAll("Verify Product properties",
				() -> assertEquals(EXPECTED.getName(), TO_BE_TESTED.getName()),
				() -> assertEquals(EXPECTED.isOnSale(), TO_BE_TESTED.isOnSale()),
				() -> assertEquals(EXPECTED.getStockQuantity(), TO_BE_TESTED.getStockQuantity()),
				() -> assertEquals(EXPECTED.getPrice(), TO_BE_TESTED.getPrice()));
	}

	class Calculator  {
		int add (int a, int b) {
			return a + b;
		}
	}
}
