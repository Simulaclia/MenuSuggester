package top.randomsuggest;

import javafx.fxml.FXML;
import top.TopPage;

public class RandomSuggestPageController {
	@FXML
	void ReturnTopPage_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

}
