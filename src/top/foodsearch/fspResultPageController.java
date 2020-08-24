package top.foodsearch;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import top.TopPage;
import top.bookmark.BookmarkPage;

public class fspResultPageController {

	@FXML
	Label menu, genre, food1, food2, food3, country, price, time, cal, protein, lipid, carbohydrate;

	@FXML
	Hyperlink url;

	static ArrayList<String> fspresultMenu;

	static String topPage;

	URI URL;

	Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

	@FXML
	void initialize() {
		menu.setText(fspresultMenu.get(0));
		country.setText(fspresultMenu.get(1));
		genre.setText(fspresultMenu.get(2));
		price.setText(fspresultMenu.get(3));
		time.setText(fspresultMenu.get(4));
		cal.setText(fspresultMenu.get(5));
		protein.setText(fspresultMenu.get(6));
		lipid.setText(fspresultMenu.get(7));
		carbohydrate.setText(fspresultMenu.get(8));
		food1.setText(fspresultMenu.get(9));
		food2.setText(fspresultMenu.get(10));
		food3.setText(fspresultMenu.get(11));
		url.setText(fspresultMenu.get(0) + "へのクックパッドリンク");

		try {
			URL = new URI(fspresultMenu.get(13));
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	@FXML
	void ReturnTopPageButton_OnClick() {
		new TopPage().changePage("topPage");
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
		BookmarkPage.AddBookmark(fspresultMenu);
	}

	public static void setData(ArrayList<String> resultRecipe, String page) {
		fspresultMenu = resultRecipe;
		topPage = page;
	}

}
