package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TableTest {

	@Test
	void isNumberEquals() {
		Table table = new EmptyTable(1);
		assertTrue(table.isNumberEquals(1));
		assertFalse(table.isNumberEquals(2));
	}

	@Test
	void hasOrderReturnTrueWhenIsOrderedTable() {
		Table table = new OrderedTable(1);
		assertTrue(table.hasOrder());
	}

	@Test
	void hasOrderReturnFalseWhenIsEmptyTable() {
		Table table = new EmptyTable(1);
		assertFalse(table.hasOrder());
	}
}