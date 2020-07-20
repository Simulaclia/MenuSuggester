package top.foodsearch;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.TopPage;
import top.seasonsearch.SeasonSearchPage;
import top.weeksuggest.WSPN2contoroller;

public class FSP_ans_Controller {

	@FXML
	private Label CookMenu1, Genre1, cooking1, calorie1, time1;

	String[] FSMenu;

	ArrayList<ArrayList<String>> searchMenu;

	String[] MainFood = FSP_Controller.getSearchFoodData();

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
		Label[][] label = { { CookMenu1 }, { Genre1 }, { cooking1 }, { calorie1 }, { time1 } };
		FSMenu = FoodSearchPage.recipeList();
	}

	void FSPSetMenu(ArrayList<ArrayList<String>> recipeList, Label[][] label) {

	}
}
