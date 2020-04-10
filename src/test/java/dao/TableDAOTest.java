package dao;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TableDAOTest {
	private TableDAO tableDAO;

	@BeforeEach
	void setUp() {
		tableDAO = new TableDAO();
	}

	@Test
	void findTableByNumber() {
		assertTrue(tableDAO.findTableByNumber(1).isNumberEquals(1));
	}

	@Test
	void findTableByNumberFails() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> tableDAO.findTableByNumber(10))
			.withMessage("존재하지 않는 테이블 번호 입니다.");
	}
}