package dao;

import java.util.List;

import domain.Menu;
import repository.MenuRepository;

public class MenuDAO {
	public Menu findMenuByNumber(int number) {
		return MenuRepository.menus().stream()
			.filter(menu -> menu.isNumberEquals(number))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴 번호 입니다."));
	}

	public List<Menu> findAll() {
		return MenuRepository.menus();
	}
}
