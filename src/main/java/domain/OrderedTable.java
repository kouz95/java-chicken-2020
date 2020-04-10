package domain;

public class OrderedTable extends Table {
	public OrderedTable(int number) {
		super(number);
	}

	public static Table of(Table table) {
		return new OrderedTable(table.number);
	}

	@Override
	public boolean hasOrder() {
		return true;
	}
}
