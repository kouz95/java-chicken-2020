package service;

import java.util.List;

import dao.MenuDAO;
import dao.TableDAO;
import domain.Menu;
import domain.Order;
import domain.PayType;
import domain.Pos;
import domain.Tables;
import domain.Table;

public class PosService {
	private static final int NO_ORDERS = 0;

	private final TableDAO tableDAO;
	private final MenuDAO menuDAO;

	public PosService(TableDAO tableDAO, MenuDAO menuDAO) {
		this.tableDAO = tableDAO;
		this.menuDAO = menuDAO;
	}

	public List<Table> showTables(Pos pos) {
		Tables tables = Tables.of(tableDAO.findAll(), pos.tables());
		return tables.toList();
	}

	public List<Menu> showMenus() {
		return menuDAO.findAll();
	}

	public void registerOrder(Pos pos, int tableNumber, int menuNumber, int menuCount) {
		pos.addOrder(new Order(tableDAO.findTableByNumber(tableNumber), menuDAO.findMenuByNumber(menuNumber), menuCount));
	}

	public double pay(int tableNumber, PayType payType, Pos pos) {
		int price = pos.calculatePriceIn(tableNumber);
		pos.deleteOrderIn(tableNumber);
		return payType.calculate(price);
	}

	public List<Order> showOrders(int tableNumber, Pos pos) {
		List<Order> orders = pos.getOrdersIn(tableNumber);
		if (orders.size() == NO_ORDERS) {
			throw new IllegalArgumentException("주문이 존재하지 않는 테이블 입니다.");
		}
		return orders;
	}
}
