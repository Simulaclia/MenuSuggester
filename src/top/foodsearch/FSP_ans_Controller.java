package top.foodsearch;

import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.TopPage;

public class FSP_ans_Controller {

	@FXML
	private Label CookMenu1, Genre1, cooking1, calorie1, time1;

	ArrayList<ArrayList<String>> FSPMenu;
	Random rand = new Random();

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
		Label[][] label = { { CookMenu1 }, { cooking1 }, { Genre1 }, { time1 }, { calorie1 } };
		FSPMenu = FoodSearchPage.FoodSearch();//レシピを持ってくる
		//System.out.println(FSPMenu + "\t");
		FSPSetMenu(FSPMenu, label);
	}

	void FSPSetMenu(ArrayList<ArrayList<String>> recipeList, Label[][] label) {

		int randomValue = rand.nextInt(recipeList.size());

		label[0][0].setText(recipeList.get(randomValue).get(0)); // 料理名
		label[1][0].setText(recipeList.get(randomValue).get(1)); // 料理国
		label[2][0].setText(recipeList.get(randomValue).get(2)); // 料理ジャンル
		label[3][0].setText(recipeList.get(randomValue).get(3)); // 所要時間
		label[4][0].setText(recipeList.get(randomValue).get(4)); // カロリー
	}
}