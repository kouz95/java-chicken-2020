package domain;

public class Order {
	private final Table table;
	private final Menu menu;
	private final MenuCount menuCount;

	public Order(Table table, Menu menu, MenuCount menuCount) {
		this.table = OrderedTable.of(table);
		this.menu = menu;
		this.menuCount = menuCount;
	}

	public boolean isTableNumberEquals(int number) {
		return table.isNumberEquals(number);
	}

	public Table getTable() {
		return table;
	}

	public String getMenuName() {
		return menu.getName();
	}

	public MenuCount getMenuCount() {
		return menuCount;
	}

	public int getPrice() {
		return menu.getTotalPrice(menuCount);
	}

	public boolean isMenuChicken() {
		return menu.isChicken();
	}
}
