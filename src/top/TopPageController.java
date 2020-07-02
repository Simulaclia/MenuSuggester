package top;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TopPageController {
	@FXML
	void SeasonSearch_onClick(ActionEvent evt) {

		try {
			Scene s = ((Node) evt.getSource()).getScene();
			Window window = s.getWindow();
			window.hide();

			AnchorPane seasonSearch = (AnchorPane) FXMLLoader
					.load(getClass().getResource("/top/seasonsearch/SeasonSearchPage.fxml"));
			Scene scene = new Scene(seasonSearch);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
