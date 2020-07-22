package top.randomsuggest;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class RandomNarrowdownController {

	//メモ
	/*
	 * ラベルの中身を取得した後、getなにがしで返す
	 * 決定ボタンに「取得+その値を返す処理+ページ遷移」する処理を追加(Narrowdownの方で)
	 * 受け取った値を処理するコードをrandomsuggestのcontrollerとかで記述
	 */

	//データ格納
	public static String[] StrNarrowDate;
	public static int[] intNarrowDate;

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
		genrecombo.getItems().addAll("和食", "洋食", "中華");

		//調理法
		cookingcombo.getItems().addAll("揚げ物", "煮物", "焼き物", "炒め物", "汁物");

		//価格
		price.getItems().addAll(700, 600, 500);

		//カロリー
		kcal.getItems().addAll(500, 400, 300);

		//所要時間
		time.getItems().addAll(60, 50, 40);
	}

	@FXML //リセットの処理
	public void ResetNarrowdownPage_OnClick() {
		genrecombo.getSelectionModel().select(0);
		cookingcombo.getSelectionModel().select(0);
		price.getSelectionModel().select(0);
		kcal.getSelectionModel().select(0);
		time.getSelectionModel().select(0);
	}

	@FXML //決定
	void okbuttonNarrowdown() {
		StrNarrowDate = new String[] { genrecombo.getValue(), cookingcombo.getValue() };
		intNarrowDate = new int[] { price.getValue(), kcal.getValue(), time.getValue() };
	}

	@FXML //データ取得
	static String[] getStrNarrowDate() {
		return StrNarrowDate;

	}

	@FXML //データ(数値)
	static int[] getintNarrowDate() {
		return intNarrowDate;
	}

}
