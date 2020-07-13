
package top.foodsearch;

import javafx.fxml.FXML;
import top.TopPage;

public class FoodSearchPageController {
	@FXML //Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML //決定ボタン→ansへ
	void nextPage_OnClick() {
		new TopPage().changePage("/top/foodsearchFoodSearchPage_ans.fxml");
	}
}