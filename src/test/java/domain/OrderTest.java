package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTest {

	private Order order;
	private Table table;
	private MenuCount menuCount;

	@BeforeEach
	void setUp() {
		table = new OrderedTable(1);
		menuCount = new MenuCount(1);

		order = new Order(table, new Menu(1, "chicken", Category.CHICKEN, 16_000), menuCount);
	}

	@Test
	void isTableNumberEquals() {
		assertThat(order.isTableNumberEquals(1)).isTrue();
		assertThat(order.isTableNumberEquals(2)).isFalse();
	}

	@Test
	void getTable() {
		assertThat(order.getTable().number).isEqualTo(table.number);
	}

	@Test
	void getMenuName() {
		assertThat(order.getMenuName()).isEqualTo("chicken");
	}

	@Test
	void getMenuCount() {
		assertThat(order.getMenuCount()).isEqualTo(menuCount);
	}

	@Test
	void getPrice() {
		assertThat(order.getPrice()).isEqualTo(16000);
	}

	@Test
	void isMenuChicken() {
		assertThat(order.isMenuChicken()).isTrue();
	}
}