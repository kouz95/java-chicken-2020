package domain;

import java.util.ArrayList;
import java.util.List;

public class Tables {
	private final List<Table> tables;

	private Tables(List<Table> tables) {
		this.tables = tables;
	}

	public static Tables of(List<Table> tables, List<Table> orderedTables) {
		List<Table> result = new ArrayList<>();

		for (Table table : tables) {
			int currentNumber = table.number;

			result.add(orderedTables.stream()
				.filter(ordered -> ordered.isNumberEquals(currentNumber))
				.findFirst()
				.orElse(table));
		}

		return new Tables(result);
	}

	public List<Table> toList() {
		return List.copyOf(tables);
	}
}
