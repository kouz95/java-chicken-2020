package domain;

import static java.util.stream.Collectors.*;

import java.util.List;

public class Pos {
	private final List<Order> orders;

	public Pos(List<Order> orders) {
		this.orders = orders;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	public List<Table> tables() {
		return orders.stream()
			.map(Order::getTable)
			.collect(toList());
	}

	public List<Order> getOrdersIn(int tableNumber) {
		return orders.stream()
			.filter(order -> order.isTableNumberEquals(tableNumber))
			.collect(toList());
	}
}
