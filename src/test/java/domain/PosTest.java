package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PosTest {

	private Order order;
	private Table table;
	private MenuCount menuCount;

	private Pos pos;

	@BeforeEach
	void setUp() {
		table = new OrderedTable(1);
		menuCount = new MenuCount(1);
		order = new Order(table, new Menu(1, "chicken", Category.CHICKEN, 16_000), menuCount);
		pos = new Pos(new ArrayList<>());
	}

	@Test
	void addOrder() {
		pos.addOrder(order);
		assertEquals(1, pos.getOrdersIn(table.number).size());
	}
}