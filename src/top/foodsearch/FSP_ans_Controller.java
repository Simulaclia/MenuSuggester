package top.foodsearch;

import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.TopPage;

public class FSP_ans_Controller {

	@FXML
	private Label CookMenu1, Genre1, cooking1, calorie1, time1;

	Random rand = new Random();

	ArrayList<ArrayList<String>> FSPRecipe;
	ArrayList<ArrayList<String>> FSPMenu;

	@FXML // Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML //食材選択に戻る
	void FoodSerach_onClick() {
		new TopPage().changePage("/top/foodsearch/FSP.fxml");
	}

	@FXML //選択食材のレシピを貼り付け
	void initialize() {
		FSPRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { CookMenu1 }, { cooking1 }, { Genre1 }, { time1 }, { calorie1 } };
		FSPMenu = FoodSearchPage.recipeList();//レシピを持ってくる
		FSPSetMenu(FSPRecipe, label);
	}

	void FSPSetMenu(ArrayList<ArrayList<String>> recipeList, Label[][] label) {
		for (int i = 0; i <= 5; i++) {
			int randomValue = rand.nextInt(recipeList.size());

			label[0][i].setText(recipeList.get(randomValue).get(0)); // 料理名
			label[1][i].setText(recipeList.get(randomValue).get(1)); // 料理国
			label[2][i].setText(recipeList.get(randomValue).get(2)); // 料理ジャンル
			label[3][i].setText(recipeList.get(randomValue).get(3)); // 所要時間
			label[4][i].setText(recipeList.get(randomValue).get(4)); // カロリー
		}
	}
}