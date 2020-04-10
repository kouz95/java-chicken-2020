package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MenuCountTest {

	@Test
	void create() {
		assertThat(new MenuCount(1)).isInstanceOf(MenuCount.class);
	}

	@Test
	void createFailsWhenExceed() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new MenuCount(100))
			.withMessage("메뉴의 개수는 99를 초과할 수 없습니다.");
	}

	@Test
	void createFailsWhenNegative() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> new MenuCount(-1))
			.withMessage("메뉴의 개수는 0 또는 음수일 수 없습니다.");
	}

	@Test
	void intValues() {
		assertEquals(1, new MenuCount(1).intValues());
	}

	@Test
	void multiply() {
		assertEquals(16, new MenuCount(2).multiply(8));
	}
}