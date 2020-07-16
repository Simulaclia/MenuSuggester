package top.foodsearch;

import javafx.fxml.FXML;
import top.TopPage;

public class FSP_ansController {

	@FXML // Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML //食材選択に戻る
	void FoodSerach_onClick() {
		new TopPage().changePage("/top/foodsearch/FoodSearchPage.fxml");
	}
}
