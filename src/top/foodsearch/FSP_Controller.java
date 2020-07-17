package top.foodsearch;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class FSP_Controller {

	@FXML //コンボボックスの型
	private ComboBox<String> FoodList;//選択食材リスト

	static String[] SearchFoodData; // 選択食材データ

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
		FoodList.getItems().addAll("食材を選択", "豚ひき肉", "キャベツ", "きくらげ", "タケノコ", "オイスターソース", "ねぎ", "きゅうり", "卵", "にんじん",
				"片栗粉", "醤油", "出汁", "味噌", "麺つゆ", "塩", "鰹節", "人参", "卵白", "里芋", "アスパラ", "ピーマン", "小麦粉", "豚バラ", "鶏もも",
				"しょうゆ", "豚肉", "マヨネーズ", "たまご", "たまねぎ", "ベーコン", "鳥もも肉", "ひき肉", "グリンピース", "バター", "じゃがいも", "鶏肉", "パン粉",
				"コーン", "デミグラスソース", "パルメザンチーズ", "ケチャップ", "なす", "酢"); // 選択食材ども
		FoodList.getSelectionModel().select(0); // 初期値
	}

	// 選択食材データ取得処理
	static String[] getSearchFoodData() {
		return SearchFoodData;
	}
}