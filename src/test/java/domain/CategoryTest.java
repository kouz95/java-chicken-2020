package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CategoryTest {

	@Test
	void testToString() {
		assertEquals("[치킨]", Category.CHICKEN.toString());
	}
}