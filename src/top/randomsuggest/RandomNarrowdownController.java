package top.randomsuggest;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class RandomNarrowdownController {

	@FXML //ページ遷移
	void ReturnRandomSuggestPage_OnClick() {
		new TopPage().changePage("/top/randomsuggest/RandomSuggestPage.fxml");
	}

	@FXML //comboboxの取得
	public ComboBox<String> genrecombo, cookingcombo;

	public ComboBox<Integer> price, kcal, time;

	@FXML //初期値設定(combobox)
	public void initialize() {
		//料理ジャンル
		genrecombo.getItems().add("和食");
		genrecombo.getItems().add("洋食");
		genrecombo.getItems().add("中華");

		//調理法
		cookingcombo.getItems().add("揚げ物");
		cookingcombo.getItems().add("煮物");
		cookingcombo.getItems().add("焼き物");
		cookingcombo.getItems().add("炒め物");
		cookingcombo.getItems().add("汁物");

		//価格
		//price.getItems().add(700);

		//カロリー
		//kcal.getItems().add(500);

		//所要時間
		//time.getItems().add(40);
	}

	@FXML //リセットの処理
	public void ResetNarrowdownPage_OnClick() {
		genrecombo.setValue("和食");
		cookingcombo.setValue("揚げ物");
		//price.setValue(700);
		//kcal.setValue(500);
		//time.setValue(40);

	}

}
