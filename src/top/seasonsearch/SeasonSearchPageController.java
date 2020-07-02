package top.seasonsearch;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SeasonSearchPageController {

	ArrayList<ArrayList<String>> seasonMenu = SeasonSearchPage.SeasonSearch();

	@FXML
	private Label label1;

	@FXML
	void initialize() {
		label1.setText(seasonMenu.get(0).get(0));
	}

}
