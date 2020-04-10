import java.util.ArrayList;

import controller.PosController;
import dao.MenuDAO;
import dao.TableDAO;
import domain.CommandType;
import domain.Pos;
import service.PosService;
import view.InputView;

public class Application {
	public static void main(String[] args) {
		Pos pos = new Pos(new ArrayList<>());
		while (true) {
			new PosController(new PosService(new TableDAO(), new MenuDAO()))
				.run(pos, CommandType.of(InputView.inputCommandNumber()));
		}
	}
}

