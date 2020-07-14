package top.foodsearch;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class FoodSearchPageController {
	@FXML // Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML // 食材決定ボタン
	void AnsPage_OnClick() {
		new TopPage().changePage("/top/foodsearch/FSP_ans.fxml");
	}

	@FXML
	void FoodSerach_onClick() {
		new TopPage().changePage("/top/foodsearch/FoodSearchPage.fxml");
	}

	public class Controller implements Initializable {

		@FXML
		private ComboBox<String> cbKind;

		public ComboBox<String> getCbKind() {
			return cbKind;
		}

		public void setCbKind(ComboBox<String> cbKind) {
			this.cbKind = cbKind;
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO 自動生成されたメソッド・スタブ
			cbKind.getItems().add("じゃがいも");
			cbKind.getItems().add("人参");
			cbKind.getItems().add("豚肉");
			cbKind.getItems().add("卵");
			cbKind.getItems().add("大根");
			cbKind.getItems().add("鶏肉");

			// 初期選択状態を設定
			cbKind.getSelectionModel().select(0);

		}
	}

	//ComboBox<String> comboBox = new ComboBox<>();
	//comboBox.getItems().addAll();

}