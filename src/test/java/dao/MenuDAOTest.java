package dao;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domain.Category;
import domain.Menu;

class MenuDAOTest {

	private MenuDAO menuDAO;

	@BeforeEach
	void setUp() {
		menuDAO = new MenuDAO();
	}

	@Test
	void findMenuByNumber() {
		assertTrue(menuDAO.findMenuByNumber(1).isNumberEquals(1));
	}

	@Test
	void findMenuByNumberFails() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> menuDAO.findMenuByNumber(10))
			.withMessage("존재하지 않는 메뉴 번호 입니다.");
	}
}