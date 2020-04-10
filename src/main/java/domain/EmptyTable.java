package domain;

public class EmptyTable extends Table {
	public EmptyTable(int number) {
		super(number);
	}

	@Override
	public boolean hasOrder() {
		return false;
	}
}
