package top.seasonsearch;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SeasonSearchPageController {

	ArrayList<ArrayList<String>> seasonMenu = SeasonSearchPage.SeasonSearch();

	@FXML
	private Label label1;

	@FXML
	void initialize() {
		label1.setText(seasonMenu.get(0).get(0));
	}

	@FXML
	void ReturnTopButton_OnClick(ActionEvent evt) {
		try {
			Scene s = ((Node) evt.getSource()).getScene();
			Window window = s.getWindow();
			window.hide();

			AnchorPane topPage = (AnchorPane) FXMLLoader.load(getClass().getResource("/top/TopPage.fxml"));
			Scene scene = new Scene(topPage);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
