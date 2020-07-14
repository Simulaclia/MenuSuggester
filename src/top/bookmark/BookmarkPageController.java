package top.bookmark;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import top.TopPage;

public class BookmarkPageController {
	@FXML
	private Label menuName1, menuName2, menuName3, genre1, genre2, genre3, cookGenre1, cookGenre2, cookGenre3, time1,
			time2, time3, cal1, cal2, cal3, noBookmarkText, pageNum;

	@FXML
	private Button deleteBookmarkButton1, deleteBookmarkButton2, deleteBookmarkButton3, backButton, nextButton;

	ArrayList<ArrayList<String>> bookmarkRecipe;

	int pageCount = 1;

	// 初期処理
	@FXML
	void initialize() {
		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		ArrayList<ArrayList<String>> bookmarkMenu = BookmarkPage.Bookmark();
		buttonHide(bookmarkMenu.size());
		bookmarkSetMenu(bookmarkMenu, label);
	}

	@FXML
	void backButton_OnClick() {
		pageCount--;

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		ArrayList<ArrayList<String>> bookmarkMenu = BookmarkPage.Bookmark();
		buttonHide(bookmarkMenu.size());
		bookmarkSetMenu(bookmarkMenu, label);
	}

	@FXML
	void nextButton_OnClick() {
		pageCount++;

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		ArrayList<ArrayList<String>> bookmarkMenu = BookmarkPage.Bookmark();
		buttonHide(bookmarkMenu.size());
		bookmarkSetMenu(bookmarkMenu, label);
	}

	@FXML
	void DeleteBookmark1_OnClick() {
		BookmarkPage.DeleteBookmark(bookmarkRecipe.get(0));

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		ArrayList<ArrayList<String>> bookmarkMenu = BookmarkPage.Bookmark();
		bookmarkSetMenu(bookmarkMenu, label);
	}

	@FXML
	void DeleteBookmark2_OnClick() {
		BookmarkPage.DeleteBookmark(bookmarkRecipe.get(1));

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		ArrayList<ArrayList<String>> bookmarkMenu = BookmarkPage.Bookmark();
		bookmarkSetMenu(bookmarkMenu, label);
	}

	@FXML
	void DeleteBookmark3_OnClick() {
		BookmarkPage.DeleteBookmark(bookmarkRecipe.get(2));

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		ArrayList<ArrayList<String>> bookmarkMenu = BookmarkPage.Bookmark();
		bookmarkSetMenu(bookmarkMenu, label);
	}

	@FXML
	void ReturnTopPage_OnClick() {
		new TopPage().changePage("/top/TopPage.fxml");
	}

	void bookmarkSetMenu(ArrayList<ArrayList<String>> bookmarkMenu, Label[][] label) {
		// ラベル初期化処理
		for (int i = 0; i <= 2; i++) {
			label[0][i].setText(""); // 料理名
			label[2][i].setText(""); // 料理ジャンル
			label[1][i].setText(""); // 料理国
			label[3][i].setText(""); // 所要時間
			label[4][i].setText(""); // カロリー
			pageNum.setText(String.valueOf(pageCount));
			deleteBookmarkButton1.setVisible(true);
			deleteBookmarkButton2.setVisible(true);
			deleteBookmarkButton3.setVisible(true);
		}
		// ブックマークされたメニューが1つも無いとき
		if (bookmarkMenu.size() == 0) {
			deleteBookmarkButton1.setVisible(false);
			deleteBookmarkButton2.setVisible(false);
			deleteBookmarkButton3.setVisible(false);

			noBookmarkText.setText("ブックマークはありません");
		}
		// ブックマークされたメニューが1つのとき
		else if (bookmarkMenu.size() - ((pageCount - 1) * 3) == 1) {
			deleteBookmarkButton2.setVisible(false);
			deleteBookmarkButton3.setVisible(false);

			label[0][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(0)); // 料理名
			label[2][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(2)); // 料理ジャンル
			label[1][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(1)); // 料理国
			label[3][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(4) + "分"); // 所要時間
			label[4][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(5) + "kcal"); // カロリー
			bookmarkRecipe.add(bookmarkMenu.get(((pageCount - 1) * 3)));

		}
		// ブックマークされたメニューが2つのとき
		else if (bookmarkMenu.size() - ((pageCount - 1) * 3) == 2) {
			deleteBookmarkButton3.setVisible(false);
			int j = 0;
			for (int i = ((pageCount - 1) * 3); i <= (((pageCount - 1) * 3) + 1); i++) {
				label[0][j].setText(bookmarkMenu.get(i).get(0)); // 料理名
				label[2][j].setText(bookmarkMenu.get(i).get(2)); // 料理ジャンル
				label[1][j].setText(bookmarkMenu.get(i).get(1)); // 料理国
				label[3][j].setText(bookmarkMenu.get(i).get(4) + "分"); // 所要時間
				label[4][j].setText(bookmarkMenu.get(i).get(5) + "kcal"); // カロリー
				bookmarkRecipe.add(bookmarkMenu.get(i));
				j++;
			}
		}
		// ブックマークされたメニューが3つのとき
		else if (bookmarkMenu.size() - ((pageCount - 1) * 3) >= 3) {
			int j = 0;
			for (int i = ((pageCount - 1) * 3); i <= ((pageCount - 1) * 3) + 2; i++) {
				label[0][j].setText(bookmarkMenu.get(i).get(0)); // 料理名
				label[2][j].setText(bookmarkMenu.get(i).get(2)); // 料理ジャンル
				label[1][j].setText(bookmarkMenu.get(i).get(1)); // 料理国
				label[3][j].setText(bookmarkMenu.get(i).get(4) + "分"); // 所要時間
				label[4][j].setText(bookmarkMenu.get(i).get(5) + "kcal"); // カロリー
				bookmarkRecipe.add(bookmarkMenu.get(i));
				j++;
			}
		} else {
			pageCount--;
			buttonHide(bookmarkMenu.size());
			bookmarkSetMenu(bookmarkMenu, label);
		}
	}

	void buttonHide(int bookmarkMenuSize) {
		if (bookmarkMenuSize <= 3) {
			backButton.setVisible(false);
			nextButton.setVisible(false);
		} else if (pageCount == 1) {
			backButton.setVisible(false);
			nextButton.setVisible(true);
		} else if ((bookmarkMenuSize - ((pageCount - 1) * 3)) <= 3) {
			backButton.setVisible(true);
			nextButton.setVisible(false);
		} else {
			backButton.setVisible(true);
			nextButton.setVisible(true);
		}
	}
}