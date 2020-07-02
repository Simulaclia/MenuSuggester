package top;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TopPage extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane topPage = (AnchorPane) FXMLLoader.load(getClass().getResource("TopPage.fxml")); // TopPage.fxml表示
			Scene scene = new Scene(topPage);
			scene.getStylesheets().add(getClass().getResource("TopPage.css").toExternalForm()); // CSS指定
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
