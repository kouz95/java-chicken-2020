package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ChickenCountTest {

	@Test
	void getDiscountAmount() {
		assertEquals(new ChickenCount(10).getDiscountAmount(), 10000);
		assertEquals(new ChickenCount(20).getDiscountAmount(), 20000);
	}

	@Test
	void getDiscountAmountWhenNoDiscounts() {
		assertEquals(new ChickenCount(9).getDiscountAmount(), 0);
	}
}