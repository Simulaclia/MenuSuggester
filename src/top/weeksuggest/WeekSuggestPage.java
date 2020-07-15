package top.weeksuggest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class WeekSuggestPage {

	public static ArrayList<ArrayList<String>> Weeksuggest() {
		try {
			// レシピCSVファイル読み込み処理
			FileInputStream fisRec = new FileInputStream("csv/Recipe.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
			BufferedReader brRec = new BufferedReader(isrRec);
			String tempData; // レシピCSVファイル一行読み込みデータ
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>(); // レシピCSVファイル絞り込み後データ

			// レシピCSVファイル絞り込み処理
			while ((tempData = brRec.readLine()) != null) { // CSVファイル内データの最後までループ
				String[] tempList = tempData.split(","); // CSVファイル一行分から","で分割して配列代入
				ArrayList<String> tempArrayList = new ArrayList<String>(); // 1行代入用
				// 配列内データをリストに代入
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}

				recipeList.add(tempArrayList); // レシピを追加
			}

			brRec.close();
			return recipeList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}