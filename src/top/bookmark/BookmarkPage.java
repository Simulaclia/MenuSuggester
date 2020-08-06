package top.bookmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BookmarkPage {

	// 絞り込み条件なしの場合
	public static ArrayList<ArrayList<String>> Bookmark() {
		try {
			// Bookmark.csvファイル読み込み
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
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
			InputStreamReader isrRec = new InputStreamReader(fisRec);
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

	public static void AddBookmark(ArrayList<String> recipe) {
		DeleteBookmark(recipe); // 重複しているブックマークの場合は元ブックマークを削除
		try {
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
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
			File deleteFile = new File("csv/Bookmark.csv");
			FileWriter deleteFilewriter = new FileWriter(deleteFile, false);
			deleteFilewriter.write("");
			deleteFilewriter.close();

			File file = new File("csv/Bookmark.csv");
			FileWriter filewriter = new FileWriter(file, true);

			int count = 1;
			for (String str : recipe) {
				// 各データにコンマを加えて書き込み
				if (count <= recipe.size() - 1)
					filewriter.write(str + ",");
				count++;
			}
			filewriter.write(recipe.get(recipe.size() - 1) + "\n");

			for (ArrayList<String> list : bookmarkList) {
				count = 1;
				for (String str : list) {
					// 各データにコンマを加えて書き込み
					if (count <= list.size() - 1)
						filewriter.write(str + ",");
					count++;
				}
				filewriter.write(list.get(list.size() - 1) + "\n");
			}
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ブックマーク削除処理
	public static void DeleteBookmark(ArrayList<String> recipe) {
		boolean change = false; // 削除対象があるかどうか
		try {
			// Bookmark.csvファイル読み込み
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
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
				File deleteFile = new File("csv/Bookmark.csv");
				FileWriter deleteFilewriter = new FileWriter(deleteFile, false);
				deleteFilewriter.write("");
				deleteFilewriter.close();

				File file = new File("csv/Bookmark.csv");
				FileWriter filewriter = new FileWriter(file, true);

				// 対象外レシピの追加処理実行
				for (ArrayList<String> list : bookmarkList) {
					int count = 1;
					for (String str : list) {
						// 各データにコンマを加えて書き込み
						if (count <= list.size() - 1)
							filewriter.write(str + ",");
						count++;
					}
					filewriter.write(list.get(list.size() - 1) + "\n");
				}
				filewriter.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}