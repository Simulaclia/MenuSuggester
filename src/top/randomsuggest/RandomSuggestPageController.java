package top.randomsuggest;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import top.TopPage;
import top.bookmark.BookmarkPage;

public class RandomSuggestPageController {

	// ラベル取得 pro=タンパク質 lip=脂質 car=炭水化物 foodstuff=食材
	@FXML
	private Label ciusinename, genre, country, price, time, cal, pro, lip, car, foodstuff1, foodstuff2, foodstuff3,
			noResultLabel;

	String[] StrNarrowData; // 絞り込み条件データ

	Random rand = new Random();
	ArrayList<String> randomRecipe;

	@FXML
	Hyperlink url;

	Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

	URI URL;
	// 初期設定

	@FXML
	void initialize() {
		Label[] Label1 = { ciusinename, country, genre, price, time, cal, pro, lip, car, foodstuff1, foodstuff2,
				foodstuff3 };

		randomRecipe = new ArrayList<String>();
		// 絞り込み条件取得
		StrNarrowData = RandomNarrowdownController.getStrNarrowDate();
		if (StrNarrowData == null) {
			ArrayList<ArrayList<String>> tempDate = RandomSuggestPage.Randomsuggest();
			RandomSetMenu(tempDate, Label1);
		} else {
			ArrayList<ArrayList<String>> tempDate = RandomSuggestPage.Randomsuggest(StrNarrowData[0], StrNarrowData[1],
					StrNarrowData[2], StrNarrowData[3], StrNarrowData[4]);
			if (tempDate.size() == 0) {

			} else {
				RandomSetMenu(tempDate, Label1);
			}

		}

		// Ransuggest = RandomSuggestPage.Randomsuggest();

		/*
		 * ↓=StrNarrowData if (deliveryData == null) { weekSuggestRandom =
		 * WeekSuggestPage.Weeksuggest(); RandomSetMenu(weekSuggestRandom, label); }
		 * else { weekSuggestRandom = WeekSuggestPage.Weeksuggest(deliveryData[0],
		 * deliveryData[1], deliveryData[2], deliveryData[3]);
		 * RandomSetMenu(weekSuggestRandom, label); }
		 */
		// if (StrNarrowData == null) {
		// tempDate = RandomSuggestPage.Randomsuggest();
		// RandomSetMenu(tempDate, Label1);
		// }
	}

	@FXML // ページ 進む
	void RandomSuggestNarrow_onClick() {
		new TopPage().changePage("/top/randomsuggest/RandomSuggestNarrowdown.fxml");
	}

	@FXML // ページ 戻る
	void ReturnTopPage_OnClick() {
		RandomNarrowdownController.resetStrNarrowDate();
		new TopPage().changePage("/top/TopPage.fxml");
	}

	@FXML
	void addBookmark_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe);
	}

	@FXML
	void url_OnClick() {

		try {
			desktop.browse(URL);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	void RandomSetMenu(ArrayList<ArrayList<String>> RandomSuggestMenu, Label[] label) {
		int randomValue = rand.nextInt(RandomSuggestMenu.size());
		// 料理名,料理国,料理ジャンル,2人前価格,料理所要時間,カロリー,
		// タンパク質量,脂質量,炭水化物量,よく使われる主食材,料理の主食材,主食材,旬の食材,クックパッドの料理名検索リンク

		label[0].setText(RandomSuggestMenu.get(randomValue).get(0)); // 料理名
		label[1].setText(RandomSuggestMenu.get(randomValue).get(1)); // 料理国
		label[2].setText(RandomSuggestMenu.get(randomValue).get(2)); // 料理ジャンル
		label[3].setText("2人前価格:" + RandomSuggestMenu.get(randomValue).get(3) + "円"); // 2人前価格
		label[4].setText("所要時間:" + RandomSuggestMenu.get(randomValue).get(4) + "分"); // 料理所要時間
		label[5].setText("カロリー:" + RandomSuggestMenu.get(randomValue).get(5) + "kcal"); // カロリー
		label[6].setText("タンパク質:" + RandomSuggestMenu.get(randomValue).get(6) + "g"); // タンパク質量
		label[7].setText("脂質:" + RandomSuggestMenu.get(randomValue).get(7) + "g"); // 脂質量
		label[8].setText("炭水化物:" + RandomSuggestMenu.get(randomValue).get(8) + "g"); // 炭水化物量
		label[9].setText(RandomSuggestMenu.get(randomValue).get(9)); // よく使われる主食材
		label[10].setText(RandomSuggestMenu.get(randomValue).get(10)); // 料理の主食材
		label[11].setText(RandomSuggestMenu.get(randomValue).get(11)); // 主食材
		// label[12].setText(RandomSuggestMenu.get(randomValue).get(12)); // 旬の食材

		url.setText(RandomSuggestMenu.get(randomValue).get(0) + "へのレシピリンク");

		try {
			URL = new URI(RandomSuggestMenu.get(randomValue).get(13));
		} catch (URISyntaxException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		randomRecipe = RandomSuggestMenu.get(randomValue);
		// System.out.println(WeekSuggestMenu.size());
		RandomSuggestMenu.remove(randomValue);

	}

}
