package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommandTypeTest {

	@Test
	void createByString() {
		assertEquals(CommandType.ORDER_REGISTERING, CommandType.of(1));
		assertEquals(CommandType.PAYMENT, CommandType.of(2));
		assertEquals(CommandType.EXIT, CommandType.of(3));
	}

	@Test
	void createFails() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> CommandType.of(4))
			.withMessage("존재하지 않는 기능 번호 입니다.");
	}
}