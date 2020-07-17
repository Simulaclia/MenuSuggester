package top.bookmark;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class BookmarkNarrowDownPageController {

	@FXML
	private ComboBox<String> genre, country, cal, price;

	private static String[] narrowDownData; // 絞り込み条件データ

	@FXML
	void initialize() {
		genre.getItems().addAll("選択なし", "揚げ物", "焼き物", "炒め物", "煮物"); // ジャンル設定
		genre.getSelectionModel().select(0); // ジャンル初期値設定
		country.getItems().addAll("選択なし", "和食", "中華", "洋食");
		country.getSelectionModel().select(0);
		cal.getItems().addAll("選択なし", "250", "500", "750");
		cal.getSelectionModel().select(0);
		price.getItems().addAll("選択なし", "250", "500", "750");
		price.getSelectionModel().select(0);
	}

	// 入力値リセットボタンクリック処理
	@FXML
	void resetButton_OnClick() {
		genre.getSelectionModel().select(0);
		country.getSelectionModel().select(0);
		cal.getSelectionModel().select(0);
		price.getSelectionModel().select(0);
	}

	// 決定ボタンクリック処理
	@FXML
	void enterButton_OnClick() {
		narrowDownData = new String[] { genre.getValue(), country.getValue(), cal.getValue(), price.getValue() }; // 絞り込み条件データ代入
		new TopPage().changePage("/top/bookmark/BookmarkPage.fxml");
	}

	// ブックマークページに戻るボタンクリック処理
	@FXML
	void ReturnBookmarkPage_OnClick() {
		new TopPage().changePage("/top/bookmark/BookmarkPage.fxml");
	}

	// 絞り込み条件データ取得処理
	static String[] getNarrowDownData() {
		return narrowDownData;
	}

	// 絞り込み条件初期化処理
	static void resetNarrowDownData() {
		narrowDownData = null;
	}
}
