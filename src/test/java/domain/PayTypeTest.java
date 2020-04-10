package domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PayTypeTest {

	@Test
	void create() {
		assertEquals(PayType.of(1), PayType.CREDIT_CARD);
		assertEquals(PayType.of(2), PayType.CASH);
	}

	@Test
	void createFails() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> PayType.of(3))
			.withMessage("존재하지 않는 결제 수단입니다.");
	}

	@Test
	void calculateWhenTypeCash() {
		assertEquals(PayType.CASH.calculate(10000), 9500);
	}

	@Test
	void calculateWhenTypeCreditCard() {
		assertEquals(PayType.CREDIT_CARD.calculate(10000), 10000);
	}
}