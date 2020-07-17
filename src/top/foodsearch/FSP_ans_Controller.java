package top.foodsearch;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.TopPage;

public class FSP_ans_Controller {

	@FXML
	private Label CookMenu1, Genre1, cooking1, calorie1, time1;

	ArrayList<ArrayList<String>> recipeList;

	String[] MainFood = FSP_Controller.getSearchFoodData();

	@FXML // Topボタン
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML //食材選択に戻る
	void FoodSerach_onClick() {
		new TopPage().changePage("/top/foodsearch/FSP.fxml");
	}

	@FXML
	void initialize() {
		recipeList = new ArrayList<ArrayList<String>>();
		Label[][] label = { { CookMenu1 }, { Genre1 }, { cooking1 }, { calorie1 }, { time1 } };
		FSPSetMenu(recipeList, label);
	}

	private void FSPSetMenu(ArrayList<ArrayList<String>> recipeList2, Label[][] label) {

	}
}
