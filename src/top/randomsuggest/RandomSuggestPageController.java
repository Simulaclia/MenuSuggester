package top.randomsuggest;

import javafx.fxml.FXML;
import top.TopPage;

public class RandomSuggestPageController {

	@FXML
	void RandomSuggestNarrow_onClick() {
		new TopPage().changePage("/top/randomsuggest/RandomSuggestNarrowdown.fxml");
	}

	@FXML
	void ReturnTopPage_OnClick() {
		//ここのTopPageは変えなくてよい
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML
	void ReturnRandomSuggestPage_OnClick() {
		new TopPage().changePage("/top.randomsuggest/RandomSuggestPage.fxml");
	}
}
