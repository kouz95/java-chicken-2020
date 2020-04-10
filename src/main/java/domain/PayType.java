package domain;

import java.util.Arrays;

public enum PayType {
	CREDIT_CARD(1),
	CASH(2);

	private final int number;

	PayType(int number) {
		this.number = number;
	}

	public static PayType of(int number) {
		return Arrays.stream(PayType.values())
			.filter(value -> value.number == number)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 결제 수단입니다."));
	}
}
