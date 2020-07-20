package top;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

public class ResultPageController {

	@FXML
	Label menu;

	@FXML
	Hyperlink url;

	static ArrayList<String> resultMenu;

	URI URL;

	Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

	@FXML
	void initialize() {
		menu.setText(resultMenu.get(0));
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
		new TopPage().changePage("/top/bookmark/BookmarkPage.fxml");
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

	public static void setData(ArrayList<String> resultRecipe) {
		resultMenu = resultRecipe;
	}

}
