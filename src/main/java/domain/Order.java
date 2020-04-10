package domain;

public class Order {
	private final Table table;
	private final Menu menu;
	private final int menuCount;

	public Order(Table table, Menu menu, int menuCount) {
		this.table = table;
		this.menu = menu;
		this.menuCount = menuCount;
	}

	public Table getTable() {
		return table;
	}
}
