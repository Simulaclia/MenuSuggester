package top.weeksuggest;

import javafx.fxml.FXML;
import top.TopPage;

public class WeekSuggestPageContoller {

	// // ラベルの取得
	// private Label CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5,
	// CookMenu6, CookMenu7, Genre1, Genre2, Genre3,
	// Genre4, Genre5, Genre6, Genre7, cooking1, cooking2, cooking3, cooking4,
	// cooking5, cooking6, cooking7, time1,
	// time2, time3, time4, time5, time6, time7, calorie1, calorie2, calorie3,
	// calorie4, calorie5, calorie6,
	// calorie7;

	// Random rand = new Random();

	// @FXML
	// void initialize() {
	// Label[][] label = { { CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5,
	// CookMenu6, CookMenu7 },
	// { Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7 },
	// { cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7 },
	// { time1, time2, time3, time4, time5, time6, time7 },
	// { calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7 } };
	// }

	// トップページに飛ぶ処理
	@FXML
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	// 絞り込み機能に飛ぶ処理
	@FXML
	void nextPage_OnClick() {
		new TopPage().changePage("/top/weeksuggest/WSPNarrow_down2.fxml");
	}

	// 一週間ランダム表示に戻る処理
	@FXML
	void backPage_button_OnClick() {
		new TopPage().changePage("/top/weeksuggest/WSPage.fxml");
	}

}
