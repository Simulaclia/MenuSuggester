package top.foodsearch;

import javafx.fxml.FXML;
import top.TopPage;

public class FoodSearchPageController {
	@FXML
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}
}
