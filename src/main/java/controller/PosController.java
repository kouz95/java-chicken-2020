package controller;

import java.util.Map;

import domain.CommandType;
import service.PosService;
import view.OutputView;

public class PosController {
	private final Map<CommandType, Runnable> commandMapper = Map.of(
		CommandType.ORDER_REGISTERING, this::registerOrder,
		CommandType.PAYMENT, this::pay,
		CommandType.EXIT, this::exit
	);

	private final PosService posService;

	public PosController(PosService posService) {
		this.posService = posService;
	}

	public void run(CommandType commandType) {
		commandMapper.get(commandType).run();
	}

	public void registerOrder() {
		OutputView.printTables(posService.showTables());
	}

	private void pay() {

	}

	private void exit() {

	}
}
