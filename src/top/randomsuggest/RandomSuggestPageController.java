package top.randomsuggest;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.TopPage;

public class RandomSuggestPageController {

	//ラベル取得　　　pro=タンパク質 lip=脂質 car=炭水化物 foodstuff=食材
	private Label ciusinename, genre, country, time, cal, pro,
			lip, car, foodstuff1, foodstuff2, foodstuff3;

	//ページ遷移設定
	@FXML
	void RandomSuggestNarrow_onClick() {
		new TopPage().changePage("/top/randomsuggest/RandomSuggestNarrowdown.fxml");
	}

	@FXML
	void ReturnTopPage_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

}
