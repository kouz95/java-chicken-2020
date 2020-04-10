package controller;

import java.util.Map;
import java.util.function.Consumer;

import static view.InputView.*;
import static view.OutputView.*;

import domain.CommandType;
import domain.PayType;
import domain.Pos;
import service.PosService;

public class PosController {
	private final Map<CommandType, Consumer<Pos>> commandMapper = Map.of(
		CommandType.ORDER_REGISTERING, this::registerOrder,
		CommandType.PAYMENT, this::pay,
		CommandType.EXIT, this::exit
	);

	private final PosService posService;

	public PosController(PosService posService) {
		this.posService = posService;
	}

	public void run(Pos pos) {
		printMainScreen();
		CommandType commandType = CommandType.of(inputCommandNumber());
		commandMapper.get(commandType).accept(pos);
	}

	public void registerOrder(Pos pos) {
		printTables(posService.showTables(pos));
		int tableNumber = inputTableNumber();
		printMenus(posService.showMenus());
		int menuNumber = inputMenuNumber();
		int menuCount = inputMenuCount();
		try {
			posService.registerOrder(pos, tableNumber, menuNumber, menuCount);
		} catch (IllegalArgumentException e) {
			printException(e.getMessage());
			registerOrder(pos);
		}
	}

	private void pay(Pos pos) {
		printTables(posService.showTables(pos));
		int tableNumber = inputTableNumber();

		try {
			printOrders(posService.showOrders(tableNumber, pos));
		} catch (IllegalArgumentException e) {
			printException(e.getMessage());
			return;
		}
		try {
			printPayProgress(tableNumber);
			printPayPrice(posService.pay(tableNumber, PayType.of(inputPayTypeNumber()), pos));
		} catch (IllegalArgumentException e) {
			printException(e.getMessage());
			pay(pos);
		}
	}

	private void exit(Pos pos) {
		System.exit(0);
	}
}
