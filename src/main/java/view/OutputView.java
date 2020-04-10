package view;

import domain.Menu;
import domain.Order;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ORDERED_BOTTOM_LINE = "└ ₩ ┘";

    public static void printMainScreen() {
        System.out.println("## 메인화면");
        System.out.println("1 - 주문등록");
        System.out.println("2 - 결제하기");
        System.out.println("3 - 프로그램 종료");
    }

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(size, tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final int count, final List<Table> tables) {

        for (int index = 0; index < count; index++) {
            if (tables.get(index).hasOrder()) {
                System.out.print(ORDERED_BOTTOM_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printOrders(List<Order> orders) {
        System.out.println("## 주문 내역");
        for (Order order : orders) {
            System.out.println("메뉴\t수량\t금액");
            System.out.printf("%s\t%d\t%d\n", order.getMenuName(), order.getMenuCount(), order.getPrice());
        }
    }

    public static void printPayProgress(int tableNumber) {
        System.out.printf("## %d번 테이블의 결제를 진행합니다.\n", tableNumber);
    }
}
