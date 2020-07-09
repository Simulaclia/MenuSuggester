package top.seasonsearch;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.TopPage;

public class SeasonSearchPageController {

	// ラベル取得
	@FXML
	private Label menuName1, menuName2, menuName3, country1, country2, country3, genre1, genre2, genre3, time1, time2,
			time3, cal1, cal2, cal3, seasonFood1, seasonFood2, seasonFood3;

	Random rand = new Random();

	// 初期処理
	@FXML
	void initialize() {
		Label[][] label = { { menuName1, menuName2, menuName3 }, { country1, country2, country3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 },
				{ seasonFood1, seasonFood2, seasonFood3 } };
		ArrayList<ArrayList<String>> seasonMenu = SeasonSearchPage.SeasonSearch(); // 旬レシピ取得
		RandomSetMenu(seasonMenu, label); // 旬レシピをランダムでラベルにセット
	}

	// 再提案ボタンクリック時処理
	@FXML
	void ReSuggest_OnClick(ActionEvent evt) {
		Label[][] label = { { menuName1, menuName2, menuName3 }, { country1, country2, country3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 },
				{ seasonFood1, seasonFood2, seasonFood3 } };
		ArrayList<ArrayList<String>> seasonMenu = SeasonSearchPage.SeasonSearch();
		RandomSetMenu(seasonMenu, label);
	}

	// Topに戻るボタンクリック時
	@FXML
	void ReturnTopButton_OnClick(ActionEvent evt) {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	// ランダムで旬レシピをラベルにセットする処理
	void RandomSetMenu(ArrayList<ArrayList<String>> seasonMenu, Label[][] label) {
		for (int i = 0; i <= 2; i++) {
			int randomValue = rand.nextInt(seasonMenu.size());
			label[0][i].setText(seasonMenu.get(randomValue).get(0)); // 料理名
			label[1][i].setText(seasonMenu.get(randomValue).get(1)); // 料理国
			label[2][i].setText(seasonMenu.get(randomValue).get(2)); // 料理ジャンル
			label[3][i].setText(seasonMenu.get(randomValue).get(4) + "分"); // 所要時間
			label[4][i].setText(seasonMenu.get(randomValue).get(5) + "kcal"); // カロリー
			label[5][i].setText(seasonMenu.get(randomValue).get(12)); // 旬食材
			seasonMenu.remove(randomValue);
		}
	}

}