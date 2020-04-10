package domain;

import java.util.Arrays;

public enum CommandType {
	ORDER_REGISTERING("1"),
	PAYMENT("2"),
	EXIT("3");

	private final String number;

	CommandType(String number) {
		this.number = number;
	}

	public static CommandType of(String number) {
		return Arrays.stream(CommandType.values())
			.filter(value -> value.number.equals(number))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기능 번호 입니다."));
	}
}
