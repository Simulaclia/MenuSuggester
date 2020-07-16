package top.bookmark;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class BookmarkNarrowDownPageController {

	@FXML
	private ComboBox<String> genre, country, cal, price;

	static String[] narrowDownData;

	@FXML
	void initialize() {
		genre.getItems().addAll("選択なし", "揚げ物", "焼き物", "炒め物", "煮物");
		genre.getSelectionModel().select(0);
		country.getItems().addAll("選択なし", "和食", "中華", "洋食");
		country.getSelectionModel().select(0);
		cal.getItems().addAll("選択なし", "250", "500", "750");
		cal.getSelectionModel().select(0);
		price.getItems().addAll("選択なし", "250", "500", "750");
		price.getSelectionModel().select(0);
	}

	@FXML
	void resetButton_OnClick() {
		genre.getSelectionModel().select(0);
		country.getSelectionModel().select(0);
		cal.getSelectionModel().select(0);
		price.getSelectionModel().select(0);
	}

	@FXML
	void enterButton_OnClick() {
		narrowDownData = new String[] { genre.getValue(), country.getValue(), cal.getValue(), price.getValue() };
		new TopPage().changePage("/top/bookmark/BookmarkPage.fxml");
	}

	@FXML
	void ReturnBookmarkPage_OnClick() {
		new TopPage().changePage("/top/bookmark/BookmarkPage.fxml");
	}

	static String[] getNarrowDownData() {
		return narrowDownData;
	}
}
