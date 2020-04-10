package dao;

import java.util.List;

import domain.Table;
import repository.TableRepository;

public class TableDAO {
	public List<Table> findAll() {
		return TableRepository.tables();
	}

	public Table findTableByNumber(int number) {
		return TableRepository.tables().stream()
			.filter(table -> table.isNumberEquals(number))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 테이블 번호 입니다."));
	}
}
