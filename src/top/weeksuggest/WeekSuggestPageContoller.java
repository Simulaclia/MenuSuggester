package top.weeksuggest;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import top.ResultPageController;
import top.TopPage;
import top.bookmark.BookmarkPage;

public class WeekSuggestPageContoller {

	// ラベルの取得
	// private Label CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5,
	// CookMenu6, CookMenu7, Genre1, Genre2, Genre3,
	// Genre4, Genre5, Genre6, Genre7, cooking1, cooking2, cooking3, cooking4,
	// cooking5, cooking6, cooking7, time1,
	// time2, time3, time4, time5, time6, time7, calorie1, calorie2, calorie3,
	// calorie4, calorie5, calorie6,
	// calorie7, WACb, YOCb, CHUCb;
	@FXML
	private Label CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7, Genre1, Genre2, Genre3,
			Genre4, Genre5, Genre6, Genre7, cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7, time1,
			time2, time3, time4, time5, time6, time7, calorie1, calorie2, calorie3, calorie4, calorie5, calorie6,
			calorie7;

	Random rand = new Random();
	// ブックマーク用の配列
	ArrayList<ArrayList<String>> randomRecipe;
	// 絞り込み条件のデータ
	String[] deliveryData;

	static ArrayList<ArrayList<String>> temporaryfood = new ArrayList<ArrayList<String>>();

	// トップページに飛ぶ処理
	@FXML
	void ReturnTopButton_OnClick(ActionEvent evt) {
		deliveryData = null;
		new TopPage().changePage("/top/TopPage.fxml");
	}

	// 絞り込み機能に飛ぶ処理
	@FXML
	void nextPage_OnClick(ActionEvent evt) {

		new TopPage().changePage("/top/weeksuggest/WSPNarrow_down2.fxml");
	}

	// ブックマークボタンを押した時の処理
	@FXML
	void bookmark_01_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe.get(0));
	}

	@FXML
	void bookmark_02_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe.get(1));
	}

	@FXML
	void bookmark_03_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe.get(2));
	}

	@FXML
	void bookmark_04_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe.get(3));
	}

	@FXML
	void bookmark_05_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe.get(4));
	}

	@FXML
	void bookmark_06_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe.get(5));
	}

	@FXML
	void bookmark_07_OnClick() {
		BookmarkPage.AddBookmark(randomRecipe.get(6));
	}

	// クックパッドへのリンク先の表示
	@FXML
	void foodMenu_On_Click1() {
		temporaryfood.clear();
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		WeekSuggestPage.Settemporaryfood(temporaryfood);
		ResultPageController.setData(randomRecipe.get(0), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void foodMenu_On_Click2() {
		temporaryfood.clear();
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		WeekSuggestPage.Settemporaryfood(temporaryfood);
		ResultPageController.setData(randomRecipe.get(1), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void foodMenu_On_Click3() {
		temporaryfood.clear();
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		WeekSuggestPage.Settemporaryfood(temporaryfood);
		ResultPageController.setData(randomRecipe.get(2), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void foodMenu_On_Click4() {
		temporaryfood.clear();
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		WeekSuggestPage.Settemporaryfood(temporaryfood);
		ResultPageController.setData(randomRecipe.get(3), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void foodMenu_On_Click5() {
		temporaryfood.clear();
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		WeekSuggestPage.Settemporaryfood(temporaryfood);
		ResultPageController.setData(randomRecipe.get(4), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void foodMenu_On_Click6() {
		temporaryfood.clear();
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		WeekSuggestPage.Settemporaryfood(temporaryfood);
		ResultPageController.setData(randomRecipe.get(5), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void foodMenu_On_Click7() {
		temporaryfood.clear();
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		WeekSuggestPage.Settemporaryfood(temporaryfood);
		ResultPageController.setData(randomRecipe.get(6), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void initialize() {
		randomRecipe = new ArrayList<ArrayList<String>>();
		// Label[][] label = { { CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5,
		// CookMenu6, CookMenu7 },
		// { Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7 },
		// { cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7 },
		// { time1, time2, time3, time4, time5, time6, time7 },
		// { calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7 } };

		Label[][] label = { { CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7 },
				{ Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7 },
				{ cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7 },
				{ time1, time2, time3, time4, time5, time6, time7 },
				{ calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7 }

		};

		// System.out.println(temporaryfood.size());

		if (WeekSuggestPage.Gettemporaryfood().size() != 0) {
			SetMenu(temporaryfood, label);
			WeekSuggestPage.Cleartemporaryfood();
		} else {
			ArrayList<ArrayList<String>> weekSuggestRandom = WeekSuggestPage.Weeksuggest();
			deliveryData = WSPN2contoroller.getdelivery();
			if (deliveryData == null || deliveryData.length == 0) {
				weekSuggestRandom = WeekSuggestPage.Weeksuggest();
				RandomSetMenu(weekSuggestRandom, label);
			} else {
				weekSuggestRandom = WeekSuggestPage.Weeksuggest(deliveryData[0], deliveryData[1], deliveryData[2],
						deliveryData[3]);
				RandomSetMenu(weekSuggestRandom, label);

			}
		}

	}

	void RandomSetMenu(ArrayList<ArrayList<String>> WeekSuggestMenu, Label[][] label) {

		// ランダムでラベルにセット
		for (int i = 0; i <= 6; i++) {
			int randomValue = rand.nextInt(WeekSuggestMenu.size());

			label[0][i].setText(WeekSuggestMenu.get(randomValue).get(0)); // 料理名
			label[1][i].setText(WeekSuggestMenu.get(randomValue).get(1)); // 料理国
			label[2][i].setText(WeekSuggestMenu.get(randomValue).get(2)); // 料理ジャンル
			label[3][i].setText(WeekSuggestMenu.get(randomValue).get(4)); // 所要時間
			label[4][i].setText(WeekSuggestMenu.get(randomValue).get(5)); // カロリー
			randomRecipe.add(WeekSuggestMenu.get(randomValue));
			// System.out.println(WeekSuggestMenu.size());
			WeekSuggestMenu.remove(randomValue);

		}

	}

	void SetMenu(ArrayList<ArrayList<String>> temporaryfood, Label[][] label) {

		for (int i = 0; i <= 6; i++) {
			label[0][i].setText(temporaryfood.get(0).get(0)); // 料理名
			label[1][i].setText(temporaryfood.get(0).get(1)); // 料理国
			label[2][i].setText(temporaryfood.get(0).get(2)); // 料理ジャンル
			label[3][i].setText(temporaryfood.get(0).get(4)); // 所要時間
			label[4][i].setText(temporaryfood.get(0).get(5)); // カロリー
			randomRecipe.add(temporaryfood.get(0));
			temporaryfood.remove(0);
		}
	}

}