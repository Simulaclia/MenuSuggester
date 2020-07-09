package top;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TopPage extends Application {
	public static Stage stage;

	@Override
	public void start(Stage stage) {
		TopPage.stage = stage;
		changePage("TopPage.fxml");
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void changePage(String fxml) {
		try {
			AnchorPane topPage = (AnchorPane) FXMLLoader.load(getClass().getResource(fxml)); // TopPage.fxml表示
			Scene scene = new Scene(topPage);
//			scene.getStylesheets().add(getClass().getResource(css).toExternalForm()); // CSS指定
			stage.setScene(scene);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
