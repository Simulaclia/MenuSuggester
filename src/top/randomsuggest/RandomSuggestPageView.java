package top.randomsuggest;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public abstract class RandomSuggestPageView extends Application {

	//BaseView<GridPane>

	//Topページ⇒ランダム献立提案のボタン
	//fx:id[RandumSuggest]

	//@Override
	public void Init() {
		try {
			AnchorPane tbutton = (AnchorPane) FXMLLoader.load(getClass().getResource("RandomSuggestPage.fxml"));
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//Button button = (Button)getObject("button");
		//Button button = (Button) getObject("topbutton");
		//button.setText("ボタン");
	}

}
/*CheckBox checkBox = (CheckBox) getObject("checkbox");
checkBox.setText("チェックボックス");

Label label = (Label) getObject("label");
label.setText("ラベル");*/