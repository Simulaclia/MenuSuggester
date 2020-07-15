package top.foodsearch;

import javafx.fxml.FXML;
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

	@FXML //ansから検索画面へ
	void FoodSerach_onClick() {
		new TopPage().changePage("/top/foodsearch/FoodSearchPage.fxml");
	}

	@FXML
	private ComboBox<String> FoodList;

	@FXML
	public void initialize() {
		// コンボボックスに項目を追加
		FoodList.getItems().add("食材を選択");
		FoodList.getItems().add("豚肉");
		FoodList.getItems().add("たまご");
		FoodList.getItems().add("鶏肉");
		FoodList.getItems().add("にんじん");
		FoodList.getItems().add("タケノコ");

		FoodList.getSelectionModel().select(0);

	}

}