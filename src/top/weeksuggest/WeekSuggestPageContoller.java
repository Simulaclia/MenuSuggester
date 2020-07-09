package top.weeksuggest;

import java.io.IOException;
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

public class WeekSuggestPageContoller {

	//ラベルの取得
	private Label CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7,
			Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7,
			cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7,
			time1, time2, time3, time4, time5, time6, time7,
			calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7;

	Random rand = new Random();

	@FXML
	void initialize() {
		Label[][] label = { { CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7 },
				{ Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7 },
				{ cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7 },
				{ time1, time2, time3, time4, time5, time6, time7 },
				{ calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7 } };
		//ArrayList<ArrayList<String>> WeekSuggest = WeekSuggestPage.WeekSuggest();
		//RandomSetMenu(WeekSuggest, label);
	}

	/*private void RandomSetMenu(ArrayList<ArrayList<String>> weekSuggest, Label[][] label) {
		// TODO 自動生成されたメソッド・スタブ
	
	}*/

	@FXML //TOPに戻るボタンの処理
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
			e.printStackTrace();
		}
	}
}
