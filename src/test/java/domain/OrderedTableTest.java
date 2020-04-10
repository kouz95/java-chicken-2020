package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrderedTableTest {
	@Test
	void create() {
		assertThat(OrderedTable.of(new EmptyTable(1))).isInstanceOf(OrderedTable.class);
	}
}