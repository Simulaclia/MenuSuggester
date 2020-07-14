package top.bookmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BookmarkPage {

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

	// ブックマーク追加処理
	public static void AddBookmark(ArrayList<String> recipe) {
		DeleteBookmark(recipe); // 重複しているブックマークの場合は元ブックマークを削除
		try {
			int count = 1;
			// Bookmark.csvに追記
			File file = new File("csv/Bookmark.csv");
			FileWriter filewriter = new FileWriter(file, true);
			// リスト内レシピをcsv形式に書き込み
			for (String str : recipe) {
				// 各データにコンマを加えて書き込み
				if (count <= recipe.size() - 1)
					filewriter.write(str + ",");
				count++;
			}
			filewriter.write(recipe.get(recipe.size() - 1) + "\n"); // 改行を加えて書き込み
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
				File file = new File("csv/Bookmark.csv");
				FileWriter filewriter = new FileWriter(file, false);
				filewriter.write("");
				filewriter.close();

				// 対象外レシピの追加処理実行
				for (ArrayList<String> list : bookmarkList) {
					AddBookmark(list);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}