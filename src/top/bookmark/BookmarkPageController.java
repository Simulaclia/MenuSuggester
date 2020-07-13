package top.bookmark;

import javafx.fxml.FXML;
import top.TopPage;

public class BookmarkPageController {
	@FXML
	void ReturnTopPage_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}
}