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
	//	private Label CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7, Genre1, Genre2, Genre3,
	//			Genre4, Genre5, Genre6, Genre7, cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7, time1,
	//			time2, time3, time4, time5, time6, time7, calorie1, calorie2, calorie3, calorie4, calorie5, calorie6,
	//			calorie7, WACb, YOCb, CHUCb;
	@FXML
	private Label CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7,
			Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7,
			cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7,
			time1, time2, time3, time4, time5, time6, time7,
			calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7;

	Random rand = new Random();
	//ブックマーク用の配列
	ArrayList<ArrayList<String>> randomRecipe;
	//絞り込み条件のデータ
	String[] deliveryData;
	//リンク先に飛んだ際のランダムに表示した物を一時的に保存しておく配列
	ArrayList<ArrayList<String>> temporaryfood = new ArrayList<ArrayList<String>>();

	// トップページに飛ぶ処理
	@FXML
	void ReturnTopButton_OnClick(ActionEvent evt) {
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

	//クックパッドへのリンク先の表示
	@FXML
	void foodMenu_On_Click1() {
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		ResultPageController.setData(randomRecipe.get(0), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");

	}

	@FXML
	void foodMenu_On_Click2() {
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		ResultPageController.setData(randomRecipe.get(1), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");

	}

	@FXML
	void foodMenu_On_Click3() {
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		ResultPageController.setData(randomRecipe.get(2), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void foodMenu_On_Click4() {
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		ResultPageController.setData(randomRecipe.get(3), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");

	}

	@FXML
	void foodMenu_On_Click5() {
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		ResultPageController.setData(randomRecipe.get(4), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");

	}

	@FXML
	void foodMenu_On_Click6() {
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		ResultPageController.setData(randomRecipe.get(5), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/Resfc ultPage.fxml");

	}

	@FXML
	void foodMenu_On_Click7() {
		for (int i = 0; i <= randomRecipe.size() - 1; i++) {
			temporaryfood.add(randomRecipe.get(i));
		}
		ResultPageController.setData(randomRecipe.get(6), "/top/weeksuggest/WSPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");

	}

	@FXML
	void initialize() {
		randomRecipe = new ArrayList<ArrayList<String>>();
		//		Label[][] label = { { CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7 },
		//				{ Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7 },
		//				{ cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7 },
		//				{ time1, time2, time3, time4, time5, time6, time7 },
		//				{ calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7 } };

		Label[][] label = { { CookMenu1, CookMenu2, CookMenu3, CookMenu4, CookMenu5, CookMenu6, CookMenu7 },
				{ Genre1, Genre2, Genre3, Genre4, Genre5, Genre6, Genre7 },
				{ cooking1, cooking2, cooking3, cooking4, cooking5, cooking6, cooking7 },
				{ time1, time2, time3, time4, time5, time6, time7 },
				{ calorie1, calorie2, calorie3, calorie4, calorie5, calorie6, calorie7 }

		};
		ArrayList<ArrayList<String>> weekSuggestRandom = WeekSuggestPage.Weeksuggest();
		//System.out.println(temporaryfood.get(0));
		//絞り込みデータの取得
		deliveryData = WSPN2contoroller.getdelivery();
		//リンク先を表示したときの一時配列にデータが入っているかの判定
		//		if (temporaryfood != null) {
		//			for (int i = 0; i <= 6; i++) {
		//
		//				label[0][i].setText(temporaryfood.get(i).get(0)); // 料理名
		//				label[1][i].setText(temporaryfood.get(i).get(1)); // 料理国
		//				label[2][i].setText(temporaryfood.get(i).get(2)); // 料理ジャンル
		//				label[3][i].setText(temporaryfood.get(i).get(4)); // 所要時間
		//				label[4][i].setText(temporaryfood.get(i).get(5)); // カロリー
		//				randomRecipe.add(temporaryfood.get(i));
		//				//temporaryfood.remove(0);
		//				//System.exit(0);
		//			}
		//		}
		//絞り込みデータがあるかないかの処理
		if (deliveryData == null) {
			weekSuggestRandom = WeekSuggestPage.Weeksuggest();
			RandomSetMenu(weekSuggestRandom, label);
		} else {
			weekSuggestRandom = WeekSuggestPage.Weeksuggest(deliveryData[0], deliveryData[1], deliveryData[2],
					deliveryData[3]);
			RandomSetMenu(weekSuggestRandom, label);
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
			//System.out.println(WeekSuggestMenu.size());
			WeekSuggestMenu.remove(randomValue);
		}

	}

}