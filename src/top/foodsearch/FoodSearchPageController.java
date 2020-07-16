package top.foodsearch;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import top.TopPage;

public class FoodSearchPageController {

	@FXML
	private Label CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7,
			Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7,
			cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7,
			time1, time2, time3, time4, time5, time6, time7,
			calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7;

	//Fsp rand = new Fsp();

	//ArrayList<ArrayList<String>> FoodRecipe;

	@FXML // Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML // 食材決定ボタン→食材検索処理開始へ行き→ansへ
	void AnsPage_OnClick() {
		new TopPage().changePage("/top/foodsearch/FSP_ans.fxml");

	}

	@FXML //ansから検索画面へ
	void FoodSerach_onClick() {
		new TopPage().changePage("/top/foodsearch/FoodSearchPage.fxml");
	}

	@FXML //コンボボックスの型
	public ComboBox<String> FoodList;

	@FXML //選択食材リスト
	void initialize() {
		// コンボボックスに項目を追加
		FoodList.getItems().add("食材を選択");
		FoodList.getItems().add("豚肉");
		FoodList.getItems().add("たまご");
		FoodList.getItems().add("鶏肉");
		FoodList.getItems().add("にんじん");
		FoodList.getItems().add("タケノコ");
		//コンボボックスの初期値
		FoodList.getSelectionModel().select(0);
	}
	/**
		@FXML
		void Fsp() {
			FoodRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7 },
				{ Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7 },
				{ cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7 },
				{ time1, time2, time3, time4, time5, time6, time7 },
				{ calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7 }};

		ArrayList<ArrayList<String>> Foodsearch = FoodSearchPage.Foodsearch();
		RandamuSetMenu(Foodsearch, label);

		void RandomSetMenu(ArrayList<ArrayList<String>> seasonMenu, Label[][] label) {
			for (int i = 0; i <= 6; i++) {
				int randomValue = rand.nextInt(seasonMenu.size());
				label[0][i].setText(seasonMenu.get(randomValue).get(0)); // 料理名
				label[1][i].setText(seasonMenu.get(randomValue).get(1)); // 料理国
				label[2][i].setText(seasonMenu.get(randomValue).get(2)); // 料理ジャンル
				label[3][i].setText(seasonMenu.get(randomValue).get(4)); // 所要時間
				label[4][i].setText(seasonMenu.get(randomValue).get(5)); // カロリー
				randomRecipe.add(seasonMenu.get(randomValue));
				seasonMenu.remove(randomValue);
			}
		}*/
}