package domain;

public class ChickenCount {
	private static final int DISCOUNTS = 10_000;
	private static final int DISCOUNT_BOUND = 10;

	private final long count;

	public ChickenCount(long count) {
		this.count = count;
	}

	public int getDiscountAmount() {
		return (int) count / DISCOUNT_BOUND * DISCOUNTS;
	}
}
