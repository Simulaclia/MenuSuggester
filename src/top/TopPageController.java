package top;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class TopPageController {
	@FXML
	void RandomSuggest_onClick(ActionEvent evt) {
		new TopPage().changePage("/top/randomsuggest/RondomSuggestPage.fxml");
	}

	@FXML
	void WeekSuggest_onClick(ActionEvent evt) {
		new TopPage().changePage("/top/weeksuggest/WSPage.fxml");
	}

	@FXML
	void FoodSerach_onClick(ActionEvent evt) {
		new TopPage().changePage("/top/foodsearch/FoodSearchPage.fxml");
	}

	@FXML
	void SeasonSearch_onClick(ActionEvent evt) {
		new TopPage().changePage("/top/seasonsearch/SeasonSearchPage.fxml");
	}

	@FXML
	void Bookmark_onClick(ActionEvent evt) {
		new TopPage().changePage("/top/bookmark/BookmarkPage.fxml");
	}
}