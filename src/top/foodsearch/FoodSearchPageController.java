
package top.foodsearch;

import javafx.fxml.FXML;
import top.TopPage;

public class FoodSearchPageController {
	@FXML //Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML //食材決定ボタン
	void AnsPage_OnClick() {
		new TopPage().changePage("/top/foodsearch/FoodSearchPage_ans.fxml");
	}
}