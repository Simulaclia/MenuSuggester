package top.seasonsearch;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import top.ResultPageController;
import top.TopPage;
import top.bookmark.BookmarkPage;

public class SeasonSearchPageController {

	// ラベル取得
	@FXML
	private Label menuName1, menuName2, menuName3, country1, country2, country3, genre1, genre2, genre3, time1, time2,
			time3, cal1, cal2, cal3, seasonFood1, seasonFood2, seasonFood3, pageNum;

	@FXML
	private Button backButton, nextButton, addBookmarkButton1, addBookmarkButton2, addBookmarkButton3;

	ArrayList<ArrayList<String>> bookmarkRecipe;

	ArrayList<ArrayList<String>> seasonMenu;

	int pageCount = 1;

	// 初期処理
	@FXML
	void initialize() {
		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { country1, country2, country3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 },
				{ seasonFood1, seasonFood2, seasonFood3 } };
		seasonMenu = SeasonSearchPage.SeasonSearch(); // 旬レシピ取得
		buttonHide(seasonMenu.size());
		SetSeasonMenu(seasonMenu, label); // 旬レシピをランダムでラベルにセット
	}

	@FXML
	void backButton_OnClick() {
		pageCount--;

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { country1, country2, country3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 },
				{ seasonFood1, seasonFood2, seasonFood3 } };
		seasonMenu = SeasonSearchPage.SeasonSearch();
		buttonHide(seasonMenu.size());
		SetSeasonMenu(seasonMenu, label);
	}

	@FXML
	void nextButton_OnClick() {
		pageCount++;

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { country1, country2, country3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 },
				{ seasonFood1, seasonFood2, seasonFood3 } };
		seasonMenu = SeasonSearchPage.SeasonSearch();
		buttonHide(seasonMenu.size());
		SetSeasonMenu(seasonMenu, label);
	}

	@FXML
	void addBookmark1_OnClick() {
		BookmarkPage.AddBookmark(bookmarkRecipe.get(0), addBookmarkButton1);
	}

	@FXML
	void addBookmark2_OnClick() {
		BookmarkPage.AddBookmark(bookmarkRecipe.get(1), addBookmarkButton2);

	}

	@FXML
	void addBookmark3_OnClick() {
		BookmarkPage.AddBookmark(bookmarkRecipe.get(2), addBookmarkButton3);
	}

	@FXML
	void menuName1_OnClick() {
		ResultPageController.setData(bookmarkRecipe.get(0), "/top/seasonsearch/SeasonSearchPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void menuName2_OnClick() {
		ResultPageController.setData(bookmarkRecipe.get(1), "/top/seasonsearch/SeasonSearchPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void menuName3_OnClick() {
		ResultPageController.setData(bookmarkRecipe.get(2), "/top/seasonsearch/SeasonSearchPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	// Topに戻るボタンクリック時
	@FXML
	void ReturnTopButton_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	void SetSeasonMenu(ArrayList<ArrayList<String>> seasonMenu, Label[][] label) {
		for (int i = 0; i <= 2; i++) {
			label[0][i].setText(""); // 料理名
			label[1][i].setText(""); // 料理国
			label[2][i].setText(""); // 料理ジャンル
			label[3][i].setText(""); // 所要時間
			label[4][i].setText(""); // カロリー
			label[5][i].setText(""); // 旬食材

			pageNum.setText(seasonMenu.size() + "件 / " + String.valueOf(pageCount) + "ページ目");
			addBookmarkButton1.setVisible(true); // お気に入りボタン1表示
			addBookmarkButton2.setVisible(true); // お気に入りボタン2表示
			addBookmarkButton3.setVisible(true); // お気に入りボタン3表示
		}
		if (seasonMenu.size() == 0) {
			addBookmarkButton1.setVisible(false); // お気に入りボタン1非表示
			addBookmarkButton2.setVisible(false); // お気に入りボタン2非表示
			addBookmarkButton3.setVisible(false); // お気に入りボタン3非表示
		} else if (seasonMenu.size() - ((pageCount - 1) * 3) == 1) {
			addBookmarkButton2.setVisible(false);
			addBookmarkButton3.setVisible(false);

			label[0][0].setText(seasonMenu.get(((pageCount - 1) * 3)).get(0));
			label[1][0].setText(seasonMenu.get(((pageCount - 1) * 3)).get(1));
			label[2][0].setText(seasonMenu.get(((pageCount - 1) * 3)).get(2));
			label[3][0].setText(seasonMenu.get(((pageCount - 1) * 3)).get(4) + "分");
			label[4][0].setText(seasonMenu.get(((pageCount - 1) * 3)).get(5) + "kcal");
			label[5][0].setText(seasonMenu.get(((pageCount - 1) * 3)).get(12));

			bookmarkRecipe.add(seasonMenu.get(((pageCount - 1) * 3)));
			if (BookmarkPage.checkBookmark(bookmarkRecipe.get(0))) {
				addBookmarkButton1.setText("お気に入り削除");
			} else {
				addBookmarkButton1.setText("お気に入り追加");
			}
		} else if (seasonMenu.size() - ((pageCount - 1) * 3) == 2) {
			addBookmarkButton3.setVisible(false);
			int j = 0;
			for (int i = ((pageCount - 1) * 3); i <= (((pageCount - 1) * 3) + 1); i++) {
				label[0][j].setText(seasonMenu.get(i).get(0));
				label[1][j].setText(seasonMenu.get(i).get(1));
				label[2][j].setText(seasonMenu.get(i).get(2));
				label[3][j].setText(seasonMenu.get(i).get(4) + "分");
				label[4][j].setText(seasonMenu.get(i).get(5) + "kcal");
				label[5][j].setText(seasonMenu.get(i).get(12));

				bookmarkRecipe.add(seasonMenu.get(i));
				j++;
			}
			if (BookmarkPage.checkBookmark(bookmarkRecipe.get(0))) {
				addBookmarkButton1.setText("お気に入り削除");
			} else {
				addBookmarkButton1.setText("お気に入り追加");
			}
			if (BookmarkPage.checkBookmark(bookmarkRecipe.get(1))) {
				addBookmarkButton2.setText("お気に入り削除");
			} else {
				addBookmarkButton2.setText("お気に入り追加");
			}
		} else if (seasonMenu.size() - ((pageCount - 1) * 3) >= 3) {
			int j = 0;
			for (int i = ((pageCount - 1) * 3); i <= ((pageCount - 1) * 3) + 2; i++) {
				label[0][j].setText(seasonMenu.get(i).get(0));
				label[1][j].setText(seasonMenu.get(i).get(1));
				label[2][j].setText(seasonMenu.get(i).get(2));
				label[3][j].setText(seasonMenu.get(i).get(4) + "分");
				label[4][j].setText(seasonMenu.get(i).get(5) + "kcal");
				label[5][j].setText(seasonMenu.get(i).get(12));

				bookmarkRecipe.add(seasonMenu.get(i));
				j++;
			}
			if (BookmarkPage.checkBookmark(bookmarkRecipe.get(0))) {
				addBookmarkButton1.setText("お気に入り削除");
			} else {
				addBookmarkButton1.setText("お気に入り追加");
			}
			if (BookmarkPage.checkBookmark(bookmarkRecipe.get(1))) {
				addBookmarkButton2.setText("お気に入り削除");
			} else {
				addBookmarkButton2.setText("お気に入り追加");
			}
			if (BookmarkPage.checkBookmark(bookmarkRecipe.get(2))) {
				addBookmarkButton3.setText("お気に入り削除");
			} else {
				addBookmarkButton3.setText("お気に入り追加");
			}
		}
	}

	void buttonHide(int seasonMenuSize) {
		if (seasonMenuSize <= 3) {
			backButton.setVisible(false);
			nextButton.setVisible(false);
		} else if (pageCount == 1) {
			backButton.setVisible(false);
			nextButton.setVisible(true);
		} else if ((seasonMenuSize - ((pageCount - 1) * 3)) <= 3) {
			backButton.setVisible(true);
			nextButton.setVisible(false);
		} else {
			backButton.setVisible(true);
			nextButton.setVisible(true);
		}
	}
}