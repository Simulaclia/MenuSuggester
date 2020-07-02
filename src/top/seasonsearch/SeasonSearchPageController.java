package top.seasonsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

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

	@FXML
	private Label menuName1;
	@FXML
	private Label menuName2;
	@FXML
	private Label menuName3;
	@FXML
	private Label country1;
	@FXML
	private Label country2;
	@FXML
	private Label country3;
	@FXML
	private Label genre1;
	@FXML
	private Label genre2;
	@FXML
	private Label genre3;
	@FXML
	private Label time1;
	@FXML
	private Label time2;
	@FXML
	private Label time3;
	@FXML
	private Label cal1;
	@FXML
	private Label cal2;
	@FXML
	private Label cal3;
	@FXML
	private Label seasonFood1;
	@FXML
	private Label seasonFood2;
	@FXML
	private Label seasonFood3;

	Random rand = new Random();

	@FXML
	void initialize() {
		Label[][] label = { { menuName1, menuName2, menuName3 }, { country1, country2, country3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 },
				{ seasonFood1, seasonFood2, seasonFood3 } };
		ArrayList<ArrayList<String>> seasonMenu = SeasonSearchPage.SeasonSearch();
		RandomSetMenu(seasonMenu, label);
	}

	@FXML
	void ReSuggest_OnClick(ActionEvent evt) {
		Label[][] label = { { menuName1, menuName2, menuName3 }, { country1, country2, country3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 },
				{ seasonFood1, seasonFood2, seasonFood3 } };
		ArrayList<ArrayList<String>> seasonMenu = SeasonSearchPage.SeasonSearch();
		RandomSetMenu(seasonMenu, label);
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

	void RandomSetMenu(ArrayList<ArrayList<String>> seasonMenu, Label[][] label) {
		for (int i = 0; i <= 2; i++) {
			int randomValue = rand.nextInt(seasonMenu.size());
			label[0][i].setText(seasonMenu.get(randomValue).get(0));
			label[1][i].setText(seasonMenu.get(randomValue).get(1));
			label[2][i].setText(seasonMenu.get(randomValue).get(2));
			label[3][i].setText(seasonMenu.get(randomValue).get(4));
			label[4][i].setText(seasonMenu.get(randomValue).get(5));
			label[5][i].setText(seasonMenu.get(randomValue).get(12));
			seasonMenu.remove(randomValue);
		}
	}

}
