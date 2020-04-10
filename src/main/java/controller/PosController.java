package controller;

import java.util.Map;

import domain.CommandType;

public class PosController {
	private final Map<CommandType, Runnable> commandMapper;

	public PosController() {
		this.commandMapper = Map.of(
			CommandType.ORDER_REGISTERING, this::registerOrder,
			CommandType.PAYMENT, this::pay,
			CommandType.EXIT, this::exit
		);
	}

	public void run(CommandType commandType) {
		commandMapper.get(commandType).run();
	}

	public void registerOrder() {

	}

	private void pay() {

	}

	private void exit() {

	}
}
