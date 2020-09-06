package top.randomsuggest;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import top.TopPage;

public class RandomNarrowdownController {

	/*
	 * メモ ラベルの中身を取得した後、getで返す 決定ボタンに「取得+その値を返す処理+ページ遷移」する処理を追加
	 * 受け取った値を処理するコードをrandomsuggestのcontrollerとかで記述
	 */

	// 絞り込みデータ格納
	public static String[] StrNarrowDate;

	@FXML // comboboxの取得
	public ComboBox<String> genrecombo, cookingcombo, price, kcal, time;

	@FXML // Labelの処理
	private Label noResultLabel, noResultLabel2;

	@FXML
	private Text genre_txt;

	@FXML // 初期値設定(combobox)
	public void initialize() {
		// 料理ジャンル
		genrecombo.getItems().addAll("選択なし", "和食", "洋食", "中華");
		genrecombo.getSelectionModel().select(0);

		// 調理法
		cookingcombo.getItems().addAll("選択なし", "揚げ物", "煮物", "焼き物", "炒め物", "汁物");
		cookingcombo.getSelectionModel().select(0);

		// 価格
		price.getItems().addAll("選択なし", "500", "600", "700");
		price.getSelectionModel().select(0);

		// カロリー
		kcal.getItems().addAll("選択なし", "500", "600", "700");
		kcal.getSelectionModel().select(0);

		// 所要時間
		time.getItems().addAll("選択なし", "40", "50", "60");
		time.getSelectionModel().select(0);
	}

	@FXML // リセットの処理
	public void ResetNarrowdownPage_OnClick() {
		genrecombo.getSelectionModel().select(0);
		cookingcombo.getSelectionModel().select(0);
		price.getSelectionModel().select(0);
		kcal.getSelectionModel().select(0);
		time.getSelectionModel().select(0);

		noResultLabel.setText("");
		noResultLabel2.setText("");
	}

	@FXML // 決定の処理 取得+その値を返す処理+ページ遷移
	// ダメだったら()内の処理を消しておく
	void okbuttonNarrowdown_OnClick() {
		if (RandomSuggestPage.Randomsuggest(genrecombo.getValue(), cookingcombo.getValue(), price.getValue(),
				kcal.getValue(), time.getValue()).size() == 0) {

			// 移動せず、条件に合致する結果がなかった事を伝える
			// あと絞り込み条件とかの表示も消す処理も
			noResultLabel.setText("条件に合う料理がありませんでした");
			noResultLabel2.setText("条件を変えて再度決定してください");

		} else {
			StrNarrowDate = new String[] { genrecombo.getValue(), cookingcombo.getValue(), price.getValue(),
					kcal.getValue(), time.getValue() };
			new TopPage().changePage("/top/randomsuggest/RandomSuggestPage.fxml");
		}

	}

	@FXML // ページ遷移
	void ReturnRandomSuggestPage_OnClick() {
		new TopPage().changePage("/top/randomsuggest/RandomSuggestPage.fxml");
	}

	@FXML // データ取得
	static String[] getStrNarrowDate() {
		return StrNarrowDate;

	}

	// 絞り込み条件初期化処理
	static void resetStrNarrowDate() {
		StrNarrowDate = null;

	}

}
