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

	public int calculatePriceIn(int tableNumber) {
		List<Order> ordersInTable = getOrdersIn(tableNumber);
		int discountAmount = new ChickenCount(ordersInTable.stream()
			.filter(Order::isMenuChicken)
			.map(Order::getMenuCount)
			.mapToInt(MenuCount::intValues)
			.sum())
			.getDiscountAmount();

		return ordersInTable.stream()
			.mapToInt(Order::getPrice)
			.sum() - discountAmount;
	}

	public void deleteOrderIn(int tableNumber) {
		orders.removeIf(order -> order.isTableNumberEquals(tableNumber));
	}
}
