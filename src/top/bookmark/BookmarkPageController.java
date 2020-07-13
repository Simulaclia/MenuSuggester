package top.bookmark;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.TopPage;

public class BookmarkPageController {
	@FXML
	private Label menuName1, menuName2, menuName3, genre1, genre2, genre3, cookGenre1, cookGenre2, cookGenre3, time1,
			time2, time3, cal1, cal2, cal3;

	// ArrayList<ArrayList<String>> bookmarkRecipe;

	// 初期処理
	@FXML
	void initialize() {
		// bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		ArrayList<ArrayList<String>> bookmarkMenu = BookmarkPage.Bookmark();
		bookmarkSetMenu(bookmarkMenu, label);
	}

	@FXML
	void ReturnTopPage_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	void bookmarkSetMenu(ArrayList<ArrayList<String>> bookmarkMenu, Label[][] label) {
		for (int i = 0; i <= 2; i++) {
			label[0][i].setText(bookmarkMenu.get(i).get(0)); // 料理名
			label[1][i].setText(bookmarkMenu.get(i).get(1)); // 料理国
			label[2][i].setText(bookmarkMenu.get(i).get(2)); // 料理ジャンル
			label[3][i].setText(bookmarkMenu.get(i).get(4) + "分"); // 所要時間
			label[4][i].setText(bookmarkMenu.get(i).get(5) + "kcal"); // カロリー
			// bookmarkRecipe.add(bookmarkMenu.get(0));
		}
	}
}