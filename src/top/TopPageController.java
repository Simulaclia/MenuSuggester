package top;

import javafx.fxml.FXML;

public class TopPageController {
	@FXML
	void RandomSuggest_onClick() {
		new TopPage().changePage("/top/randomsuggest/RandomSuggestPage.fxml");
	}

	@FXML
	void WeekSuggest_onClick() {
		new TopPage().changePage("/top/weeksuggest/WSPage.fxml");
	}

	@FXML
	void FoodSerach_onClick() {
		new TopPage().changePage("/top/foodsearch/FoodSearchPage.fxml");
	}

	@FXML
	void SeasonSearch_onClick() {
		new TopPage().changePage("/top/seasonsearch/SeasonSearchPage.fxml");
	}

	@FXML
	void Bookmark_onClick() {
		new TopPage().changePage("/top/bookmark/BookmarkPage.fxml");
	}
}