package top;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import top.bookmark.BookmarkPage;

public class ResultPageController {

	@FXML
	Label menu, genre, food1, food2, food3, country, price, time, cal, protein, lipid, carbohydrate;

	@FXML
	Hyperlink url;

	static ArrayList<String> resultMenu;

	static String backPage, backPageCss;

	static boolean hasCss = false;

	URI URL;

	Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

	@FXML
	void initialize() {
		menu.setText(resultMenu.get(0));
		country.setText(resultMenu.get(1));
		genre.setText(resultMenu.get(2));
		price.setText(resultMenu.get(3));
		time.setText(resultMenu.get(4));
		cal.setText(resultMenu.get(5));
		protein.setText(resultMenu.get(6));
		lipid.setText(resultMenu.get(7));
		carbohydrate.setText(resultMenu.get(8));
		food1.setText(resultMenu.get(9));
		food2.setText(resultMenu.get(10));
		food3.setText(resultMenu.get(11));
		url.setText(resultMenu.get(0) + "へのクックパッドリンク");

		try {
			URL = new URI(resultMenu.get(13));
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@FXML
	void ReturnPageButton_OnClick() {
		if (hasCss) {
			new TopPage().changePage(backPage, backPageCss);
		} else {
			new TopPage().changePage(backPage);
		}
	}

	@FXML
	void url_OnClick() {

		try {
			desktop.browse(URL);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@FXML
	void addBookmark_OnClick() {
		BookmarkPage.AddBookmark(resultMenu);
	}

	public static void setData(ArrayList<String> resultRecipe, String page) {
		resultMenu = resultRecipe;
		backPage = page;
	}

	public static void setData(ArrayList<String> resultRecipe, String page, String css) {
		resultMenu = resultRecipe;
		backPage = page;
		backPageCss = css;
		hasCss = true;
	}

}
