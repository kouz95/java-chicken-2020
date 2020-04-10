package domain;

public abstract class Table {
    protected final int number;

    protected Table(final int number) {
        this.number = number;
    }

    public boolean isNumberEquals(int number) {
        return this.number == number;
    }

    public abstract boolean hasOrder();

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
