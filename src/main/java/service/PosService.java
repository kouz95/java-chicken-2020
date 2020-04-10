package service;

import java.util.List;

import dao.MenuDAO;
import dao.TableDAO;
import domain.Menu;
import domain.Order;
import domain.Pos;
import domain.Tables;
import repository.MenuRepository;
import domain.Table;

public class PosService {
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
}
