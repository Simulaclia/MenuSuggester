package top.bookmark;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.scene.control.Button;

public class BookmarkPage {

	// 絞り込み条件なしの場合
	public static ArrayList<ArrayList<String>> Bookmark() {
		try {
			// Bookmark.csvファイル読み込み
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec, "UTF-8");
			BufferedReader brRec = new BufferedReader(isrRec);

			String tempData;
			ArrayList<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>(); // Bookmark.csv内のレシピリスト

			// リスト代入処理
			while ((tempData = brRec.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				bookmarkList.add(tempArrayList);
			}
			brRec.close();
			return bookmarkList; // Bookmark.csv内レシピリスト返却
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 絞り込み条件ありの場合
	public static ArrayList<ArrayList<String>> Bookmark(String genre, String country, String cal, String price) {
		try {
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec, "UTF-8");
			BufferedReader brRec = new BufferedReader(isrRec);

			String tempData;
			ArrayList<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();

			while ((tempData = brRec.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				// 絞り込み処理
				if ((tempArrayList.get(2).equals(genre) || genre.equals("選択なし")) // ジャンル絞り込み
						&& (tempArrayList.get(1).equals(country) || country.equals("選択なし")) // 料理国絞り込み
						&& (cal.equals("選択なし") || (Integer.parseInt(tempArrayList.get(5)) <= (Integer.parseInt(cal)))) // カロリー絞り込み
						&& (price.equals("選択なし")
								|| (Integer.parseInt(tempArrayList.get(3)) <= (Integer.parseInt(price)))) // 価格絞り込み
				) {
					bookmarkList.add(tempArrayList); // 合致したレシピを追加
				}
			}
			brRec.close();
			return bookmarkList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ブックマーク追加処理
	// public static void AddBookmark(ArrayList<String> recipe) {
	// DeleteBookmark(recipe); // 重複しているブックマークの場合は元ブックマークを削除
	// try {
	// int count = 1;
	// // Bookmark.csvに追記
	// File file = new File("csv/Bookmark.csv");
	// FileWriter filewriter = new FileWriter(file, true);
	// // リスト内レシピをcsv形式に書き込み
	// for (String str : recipe) {
	// // 各データにコンマを加えて書き込み
	// if (count <= recipe.size() - 1)
	// filewriter.write(str + ",");
	// count++;
	// }
	// filewriter.write(recipe.get(recipe.size() - 1) + "\n"); // 改行を加えて書き込み
	// filewriter.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }

	// ブックマーク追加処理(上書き)
	public static void AddBookmark(ArrayList<String> recipe) {
		DeleteBookmark(recipe); // 重複しているブックマークの場合は元ブックマークを削除
		try {
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec, "UTF-8");
			BufferedReader brRec = new BufferedReader(isrRec);

			String tempData;
			ArrayList<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();

			while ((tempData = brRec.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				bookmarkList.add(tempArrayList);
			}

			brRec.close();

			// Bookmark.csv初期化
			PrintWriter deletePrintWriter = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("csv/Bookmark.csv", false), "UTF-8")));

			deletePrintWriter.print("");
			deletePrintWriter.close();

			PrintWriter printWriter = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream("csv/Bookmark.csv", true), "UTF-8")));

			int count = 1;
			for (String str : recipe) {
				// 各データにコンマを加えて書き込み
				if (count <= recipe.size() - 1)
					printWriter.print(str + ",");
				count++;
			}
			printWriter.print(recipe.get(recipe.size() - 1) + "\n");

			for (ArrayList<String> list : bookmarkList) {
				count = 1;
				for (String str : list) {
					// 各データにコンマを加えて書き込み
					if (count <= list.size() - 1)
						printWriter.print(str + ",");
					count++;
				}
				printWriter.print(list.get(list.size() - 1) + "\n");
			}
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ブックマーク追加処理(削除)
	public static void AddBookmark(ArrayList<String> recipe, Button button) {
		// レシピ重複チェック
		if (checkBookmark(recipe)) {
			DeleteBookmark(recipe);
			button.setText("お気に入り追加"); // ボタンラベル表記変更
		} else {
			button.setText("お気に入り削除");
			try {
				FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
				InputStreamReader isrRec = new InputStreamReader(fisRec, "UTF-8");
				BufferedReader brRec = new BufferedReader(isrRec);

				String tempData;
				ArrayList<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();

				while ((tempData = brRec.readLine()) != null) {
					String[] tempList = tempData.split(",");
					ArrayList<String> tempArrayList = new ArrayList<String>();
					for (String tempLi : tempList) {
						tempArrayList.add(tempLi);
					}
					bookmarkList.add(tempArrayList);
				}

				brRec.close();

				// Bookmark.csv初期化
				PrintWriter deletePrintWriter = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("csv/Bookmark.csv", false), "UTF-8")));

				deletePrintWriter.print("");
				deletePrintWriter.close();

				PrintWriter printWriter = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("csv/Bookmark.csv", true), "UTF-8")));

				int count = 1;
				for (String str : recipe) {
					// 各データにコンマを加えて書き込み
					if (count <= recipe.size() - 1)
						printWriter.print(str + ",");
					count++;
				}
				printWriter.print(recipe.get(recipe.size() - 1) + "\n");

				for (ArrayList<String> list : bookmarkList) {
					count = 1;
					for (String str : list) {
						// 各データにコンマを加えて書き込み
						if (count <= list.size() - 1)
							printWriter.print(str + ",");
						count++;
					}
					printWriter.print(list.get(list.size() - 1) + "\n");
				}
				printWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// ブックマーク削除処理
	public static void DeleteBookmark(ArrayList<String> recipe) {
		boolean change = false; // 削除対象があるかどうか
		try {
			// Bookmark.csvファイル読み込み
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec, "UTF-8");
			BufferedReader brRec = new BufferedReader(isrRec);

			String tempData;
			ArrayList<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>(); // 削除後レシピリスト代入用

			// リスト代入処理
			while ((tempData = brRec.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				// メニュー名と炭水化物量が合致しない場合に追加
				if (!(recipe.get(0).equals(tempArrayList.get(0)) && recipe.get(8).equals(tempArrayList.get(8)))) {
					bookmarkList.add(tempArrayList);
				} else {
					change = true;
				}
			}

			brRec.close();

			// 削除対象があった場合
			if (change) {
				// Bookmark.csv初期化
				PrintWriter deletePrintWriter = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("csv/Bookmark.csv", false), "UTF-8")));

				deletePrintWriter.print("");
				deletePrintWriter.close();

				PrintWriter printWriter = new PrintWriter(new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream("csv/Bookmark.csv", true), "UTF-8")));

				// 対象外レシピの追加処理実行
				for (ArrayList<String> list : bookmarkList) {
					int count = 1;
					for (String str : list) {
						// 各データにコンマを加えて書き込み
						if (count <= list.size() - 1)
							printWriter.print(str + ",");
						count++;
					}
					printWriter.print(list.get(list.size() - 1) + "\n");
				}
				printWriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean checkBookmark(ArrayList<String> recipe) {
		try {
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec, "UTF-8");
			BufferedReader brRec = new BufferedReader(isrRec);

			String tempData;

			while ((tempData = brRec.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				if (recipe.get(0).equals(tempArrayList.get(0)) && recipe.get(8).equals(tempArrayList.get(8))) {
					brRec.close();
					return true;
				}
			}
			brRec.close();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void setBookmarkText(Button[] button, ArrayList<ArrayList<String>> bookmarkRecipe) {
		for (int i = 0; i <= bookmarkRecipe.size() - 1; i++) {
			if (BookmarkPage.checkBookmark(bookmarkRecipe.get(i))) {
				button[i].setText("お気に入り削除");
			} else {
				button[i].setText("お気に入り追加");
			}
		}
	}

}