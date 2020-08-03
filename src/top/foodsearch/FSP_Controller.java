package top.foodsearch;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class FSP_Controller {

	@FXML //コンボボックスの型
	private ComboBox<String> FoodList;//選択食材リスト

	private static String[] SearchFoodData; // 選択食材データ

	@FXML // Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML // 「食材決定ボタン」食材検索処理開始へ行き→ansへ遷移
	void AnsPage_OnClick() {
		SearchFoodData = new String[] { FoodList.getValue() }; // 選択食材データ代入
		new TopPage().changePage("/top/foodsearch/FSP_ans.fxml");
	}

	@FXML //選択食材リスト
	void initialize() {
		// リストに食材を追加
		FoodList.getItems().addAll("食材を選択", "豚肉", "牛肉", "鶏肉", "じゃがいも", "大根", "タケノコ", "かぼちゃ", "大豆",
				"キャベツ", "にんじん", "コーン", "白菜", "ナス", "卵", "鯖", "鰆", "鮭", "鰹", "貝", "海老", "ナス", "タコ", "イカ", "カレイ"); // 選択食材ども
		FoodList.getSelectionModel().select(0); // 初期値
	}

	static String[] getSearchFoodData() {
		return SearchFoodData;
	}
}