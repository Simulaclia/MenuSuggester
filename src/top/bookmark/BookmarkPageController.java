package top.bookmark;

import javafx.fxml.FXML;

public class BookmarkPageController {
	@FXML
	void Button_OnClick() {
		BookmarkPage.addBookmark();
	}
}