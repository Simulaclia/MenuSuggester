package top.bookmark;

import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import top.ResultPageController;
import top.TopPage;

public class BookmarkPageController {
	// ラベル取得
	@FXML
	private Label menuName1, menuName2, menuName3, genre1, genre2, genre3, cookGenre1, cookGenre2, cookGenre3, time1,
			time2, time3, cal1, cal2, cal3, noBookmarkText, pageNum;

	// ボタン取得
	@FXML
	private Button deleteBookmarkButton1, deleteBookmarkButton2, deleteBookmarkButton3, backButton, nextButton;

	ArrayList<ArrayList<String>> bookmarkRecipe; // ブックマークされているレシピ用リスト

	ArrayList<ArrayList<String>> bookmarkMenu; // 絞り込み後レシピリスト

	String[] narrowDownData; // 絞り込み条件データ

	int pageCount; // 現在ページ数

	// 初期処理
	@FXML
	void initialize() {
		pageCount = 1;
		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };

		narrowDownData = BookmarkNarrowDownPageController.getNarrowDownData(); // 絞り込み条件取得

		// 絞り込み条件が取得されていない場合
		if (narrowDownData == null) {
			bookmarkMenu = BookmarkPage.Bookmark(); // ブックマークされているレシピリスト取得
			buttonHide(bookmarkMenu.size()); // 前へ・次へボタンの表示・非表示処理
			bookmarkSetMenu(bookmarkMenu, label); // ブックマークをラベルへセットする処理
		}
		// 絞り込み条件が取得されている場合
		else {
			bookmarkMenu = BookmarkPage.Bookmark(narrowDownData[0], narrowDownData[1], narrowDownData[2],
					narrowDownData[3]); // ブックマークされているレシピリストを絞り込んで取得
			buttonHide(bookmarkMenu.size());
			bookmarkSetMenu(bookmarkMenu, label);
		}
	}

	// 前へボタンクリック処理
	@FXML
	void backButton_OnClick() {
		pageCount--;

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		buttonHide(bookmarkMenu.size());
		bookmarkSetMenu(bookmarkMenu, label);
	}

	// 次へボタンクリック処理
	@FXML
	void nextButton_OnClick() {
		pageCount++;

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		buttonHide(bookmarkMenu.size());
		bookmarkSetMenu(bookmarkMenu, label);
	}

	// 絞り込みボタンクリック処理
	@FXML
	void NarrowDowntButton_OnClick() {
		new TopPage().changePage("/top/bookmark/BookmarkNarrowDownPage.fxml");
	}

	// お気に入り解除ボタン1クリック処理
	@FXML
	void DeleteBookmark1_OnClick() {
		BookmarkPage.DeleteBookmark(bookmarkRecipe.get(0)); // ブックマーク削除処理

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		if (narrowDownData == null) {
			bookmarkMenu = BookmarkPage.Bookmark(); // ブックマークされているレシピリスト取得
			buttonHide(bookmarkMenu.size()); // 前へ・次へボタンの表示・非表示処理
			bookmarkSetMenu(bookmarkMenu, label); // ブックマークをラベルへセットする処理
		}
		// 絞り込み条件が取得されている場合
		else {
			bookmarkMenu = BookmarkPage.Bookmark(narrowDownData[0], narrowDownData[1], narrowDownData[2],
					narrowDownData[3]); // ブックマークされているレシピリストを絞り込んで取得
			buttonHide(bookmarkMenu.size());
			bookmarkSetMenu(bookmarkMenu, label);
		}
	}

	// お気に入り解除ボタン2クリック処理
	@FXML
	void DeleteBookmark2_OnClick() {
		BookmarkPage.DeleteBookmark(bookmarkRecipe.get(1));

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		if (narrowDownData == null) {
			bookmarkMenu = BookmarkPage.Bookmark(); // ブックマークされているレシピリスト取得
			buttonHide(bookmarkMenu.size()); // 前へ・次へボタンの表示・非表示処理
			bookmarkSetMenu(bookmarkMenu, label); // ブックマークをラベルへセットする処理
		}
		// 絞り込み条件が取得されている場合
		else {
			bookmarkMenu = BookmarkPage.Bookmark(narrowDownData[0], narrowDownData[1], narrowDownData[2],
					narrowDownData[3]); // ブックマークされているレシピリストを絞り込んで取得
			buttonHide(bookmarkMenu.size());
			bookmarkSetMenu(bookmarkMenu, label);
		}
	}

	// お気に入り解除ボタン3クリック処理
	@FXML
	void DeleteBookmark3_OnClick() {
		BookmarkPage.DeleteBookmark(bookmarkRecipe.get(2));

		bookmarkRecipe = new ArrayList<ArrayList<String>>();
		Label[][] label = { { menuName1, menuName2, menuName3 }, { cookGenre1, cookGenre2, cookGenre3 },
				{ genre1, genre2, genre3 }, { time1, time2, time3 }, { cal1, cal2, cal3 } };
		if (narrowDownData == null) {
			bookmarkMenu = BookmarkPage.Bookmark(); // ブックマークされているレシピリスト取得
			buttonHide(bookmarkMenu.size()); // 前へ・次へボタンの表示・非表示処理
			bookmarkSetMenu(bookmarkMenu, label); // ブックマークをラベルへセットする処理
		}
		// 絞り込み条件が取得されている場合
		else {
			bookmarkMenu = BookmarkPage.Bookmark(narrowDownData[0], narrowDownData[1], narrowDownData[2],
					narrowDownData[3]); // ブックマークされているレシピリストを絞り込んで取得
			buttonHide(bookmarkMenu.size());
			bookmarkSetMenu(bookmarkMenu, label);
		}
	}

	@FXML
	void menuName1_OnClick() {
		ResultPageController.setData(bookmarkRecipe.get(0), "/top/bookmark/BookmarkPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void menuName2_OnClick() {
		ResultPageController.setData(bookmarkRecipe.get(1), "/top/bookmark/BookmarkPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	@FXML
	void menuName3_OnClick() {
		ResultPageController.setData(bookmarkRecipe.get(2), "/top/bookmark/BookmarkPage.fxml");
		new TopPage().changePage("/top/ResultPage.fxml");
	}

	// Topへ戻るボタンクリック処理
	@FXML
	void ReturnTopPage_OnClick() {
		BookmarkNarrowDownPageController.resetNarrowDownData();
		new TopPage().changePage("/top/TopPage.fxml");
	}

	// ブックマークをラベルへセットする処理
	void bookmarkSetMenu(ArrayList<ArrayList<String>> bookmarkMenu, Label[][] label) {
		// ラベル初期化処理
		for (int i = 0; i <= 2; i++) {
			label[0][i].setText(""); // 料理名
			label[2][i].setText(""); // 料理ジャンル
			label[1][i].setText(""); // 料理国
			label[3][i].setText(""); // 所要時間
			label[4][i].setText(""); // カロリー
			pageNum.setText(bookmarkMenu.size() + "件 / " + String.valueOf(pageCount) + "ページ目"); // ページ数セット
			deleteBookmarkButton1.setVisible(true); // お気に入り解除ボタン1表示
			deleteBookmarkButton2.setVisible(true); // お気に入り解除ボタン2表示
			deleteBookmarkButton3.setVisible(true); // お気に入り解除ボタン3表示
		}
		// ブックマークされたメニューが1つも無いとき
		if (bookmarkMenu.size() == 0) {
			deleteBookmarkButton1.setVisible(false); // お気に入り解除ボタン1非表示
			deleteBookmarkButton2.setVisible(false); // お気に入り解除ボタン2非表示
			deleteBookmarkButton3.setVisible(false); // お気に入り解除ボタン3非表示

			noBookmarkText.setText("条件に合致したブックマークはありません");
		}
		// ブックマークされたメニューが1つのとき
		else if (bookmarkMenu.size() - ((pageCount - 1) * 3) == 1) {
			deleteBookmarkButton2.setVisible(false); // お気に入り解除ボタン2非表示
			deleteBookmarkButton3.setVisible(false); // お気に入り解除ボタン3非表示

			// 1段目のみ代入
			label[0][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(0));
			label[2][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(2));
			label[1][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(1));
			label[3][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(4) + "分");
			label[4][0].setText(bookmarkMenu.get(((pageCount - 1) * 3)).get(5) + "kcal");
			bookmarkRecipe.add(bookmarkMenu.get(((pageCount - 1) * 3))); // ブックマーク追加処理用リスト追加
		}
		// ブックマークされたメニューが2つのとき
		else if (bookmarkMenu.size() - ((pageCount - 1) * 3) == 2) {
			deleteBookmarkButton3.setVisible(false);// お気に入り解除ボタン3非表示

			int j = 0;
			for (int i = ((pageCount - 1) * 3); i <= (((pageCount - 1) * 3) + 1); i++) {

				// 1,2段目代入
				label[0][j].setText(bookmarkMenu.get(i).get(0));
				label[2][j].setText(bookmarkMenu.get(i).get(2));
				label[1][j].setText(bookmarkMenu.get(i).get(1));
				label[3][j].setText(bookmarkMenu.get(i).get(4) + "分");
				label[4][j].setText(bookmarkMenu.get(i).get(5) + "kcal");
				bookmarkRecipe.add(bookmarkMenu.get(i));
				j++;
			}
		}
		// ブックマークされたメニューが3つのとき
		else if (bookmarkMenu.size() - ((pageCount - 1) * 3) >= 3) {
			int j = 0;
			for (int i = ((pageCount - 1) * 3); i <= ((pageCount - 1) * 3) + 2; i++) {
				// 全段代入
				label[0][j].setText(bookmarkMenu.get(i).get(0));
				label[2][j].setText(bookmarkMenu.get(i).get(2));
				label[1][j].setText(bookmarkMenu.get(i).get(1));
				label[3][j].setText(bookmarkMenu.get(i).get(4) + "分");
				label[4][j].setText(bookmarkMenu.get(i).get(5) + "kcal");
				bookmarkRecipe.add(bookmarkMenu.get(i));
				j++;
			}
		}
		// ページ数減少処理
		else {
			pageCount--; // ページ減少
			buttonHide(bookmarkMenu.size());
			bookmarkSetMenu(bookmarkMenu, label);
		}
	}

	// 前へ・次へボタン表示・非表示処理
	void buttonHide(int bookmarkMenuSize) {
		// ブックマークレシピ数が3つ以下の場合
		if (bookmarkMenuSize <= 3) {
			backButton.setVisible(false); // 前へボタン非表示
			nextButton.setVisible(false); // 次へボタン非表示
		}
		// 1ページ目の場合
		else if (pageCount == 1) {
			backButton.setVisible(false);
			nextButton.setVisible(true); // 次へボタン表示
		}
		// 最終ページの場合
		else if ((bookmarkMenuSize - ((pageCount - 1) * 3)) <= 3) {
			backButton.setVisible(true); // 前へボタン表示
			nextButton.setVisible(false);
		}
		// 途中ページの場合
		else {
			backButton.setVisible(true);
			nextButton.setVisible(true);
		}
	}
}