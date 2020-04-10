package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.MenuDAO;

class MenuTest {
	private Menu chicken;
	private Menu beverage;

	@BeforeEach
	void setUp() {
		chicken = new Menu(1, "chicken", Category.CHICKEN, 16_000);
		beverage = new Menu(21, "beverage", Category.BEVERAGE, 1_000);
	}

	@Test
	void isNumberEquals() {
		assertTrue(chicken.isNumberEquals(1));
	}

	@Test
	void calculatePriceForBeverage() {
		assertEquals(10000, beverage.getTotalPrice(10));
	}

	@Test
	void calculatePriceForChicken() {
		assertEquals(chicken.getTotalPrice(1) * 10, chicken.getTotalPrice(10));
	}

	@Test
	void isChicken() {
		assertTrue(chicken.isChicken());
		assertFalse(beverage.isChicken());
	}

	@Test
	void getName() {
		assertEquals("chicken", chicken.getName());
	}
}