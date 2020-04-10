package domain;

import java.util.Arrays;

public enum CommandType {
	ORDER_REGISTERING(1),
	PAYMENT(2),
	EXIT(3);

	private final int number;

	CommandType(int number) {
		this.number = number;
	}

	public static CommandType of(int number) {
		return Arrays.stream(CommandType.values())
			.filter(value -> value.number == number)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기능 번호 입니다."));
	}
}
