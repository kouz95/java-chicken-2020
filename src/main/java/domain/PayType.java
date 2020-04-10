package domain;

import java.util.Arrays;
import java.util.function.Function;

public enum PayType {
	CREDIT_CARD(1, price -> (double) price),
	CASH(2, price -> price * 0.95);

	private final int number;
	private final Function<Integer, Double> discountStrategy;

	PayType(int number, Function<Integer, Double> discountStrategy) {
		this.number = number;
		this.discountStrategy = discountStrategy;
	}

	public static PayType of(int number) {
		return Arrays.stream(PayType.values())
			.filter(value -> value.number == number)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 결제 수단입니다."));
	}

	public double calculate(int price) {
		return discountStrategy.apply(price);
	}
}
