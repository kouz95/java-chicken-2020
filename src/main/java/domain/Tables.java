package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tables {
	private final Map<Table, Boolean> tables;

	private Tables(Map<Table, Boolean> tables) {
		this.tables = tables;
	}

	public static Tables of(List<Table> tables, List<Table> orderedTables) {
		Map<Table, Boolean> result = new HashMap<>();

		for (Table table : tables) {
			result.put(table, false);
		}
		for (Table ordered : orderedTables) {
			result.replace(ordered, true);
		}

		return new Tables(result);
	}

	public List<Table> toList() {
		return List.copyOf(tables.keySet());
	}
}
