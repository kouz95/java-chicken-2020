package domain;

public class MenuCount {
	private static final int MAX_COUNT = 99;
	private static final int MIN_COUNT = 0;

	private final int count;

	public MenuCount(int count) {
		verify(count);
		this.count = count;
	}

	private void verify(int count) {
		if (count > MAX_COUNT) {
			throw new IllegalArgumentException("메뉴의 개수는 99를 초과할 수 없습니다.");
		}
		if (count <= MIN_COUNT) {
			throw new IllegalArgumentException("메뉴의 개수는 0 또는 음수일 수 없습니다.");
		}
	}

	public int intValues() {
		return count;
	}

	public int multiply(int price) {
		return count * price;
	}
}
