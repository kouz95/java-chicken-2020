package service;

import java.util.List;

import repository.OrderRepository;
import domain.Table;
import repository.TableRepository;

public class PosService {
	private final OrderRepository orderRepository;

	public PosService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	// TODO: 2020/04/10 주문이 있는지 확인
	public List<Table> showTables() {
		return TableRepository.tables();
	}
}
