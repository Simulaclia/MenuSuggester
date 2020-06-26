package top.seasonsearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class SeasonSearchPage {
	public SeasonSearchPage() {
		Calendar calendar = Calendar.getInstance();

		try {

			// レシピCSVファイル読み込み処理
			FileInputStream fisRec = new FileInputStream("csv/Recipe.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
			BufferedReader brRec = new BufferedReader(isrRec);
			String tempData; // レシピCSVファイル一行読み込みデータ
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>(); // レシピCSVファイル絞り込み後データ

			// 旬食材CSVファイル読み込み処理
			FileInputStream fisFoo = new FileInputStream("csv/FoodSeason.csv");
			InputStreamReader isrFoo = new InputStreamReader(fisFoo);
			BufferedReader brFoo = new BufferedReader(isrFoo);
			String tempSeasonFoodData; // CSVファイル一行読み込みデータ
			ArrayList<String> seasonFoodArrayList = new ArrayList<String>(); // 旬食材CSVファイル絞り込み後データ

			// 旬食材CSVファイル絞り込み処理
			int i = 0; // 月カウント
			while ((tempSeasonFoodData = brFoo.readLine()) != null) { // CSVファイル内データの最後までループ
				if (i == calendar.get(Calendar.MONTH) + 1 - 1) { // 現在月と合致した行を取得
					String[] tempFoodList = tempSeasonFoodData.split(","); // CSVファイル一行分から","で分割して配列代入
					// 配列内データをリストに代入
					for (String tempFo : tempFoodList) {
						seasonFoodArrayList.add(tempFo);
					}
				}
				i++;
			}

			// レシピCSVファイル絞り込み処理
			while ((tempData = brRec.readLine()) != null) { // CSVファイル内データの最後までループ
				String[] tempList = tempData.split(","); // CSVファイル一行分から","で分割して配列代入
				ArrayList<String> tempArrayList = new ArrayList<String>(); // 1行代入用
				// 配列内データをリストに代入
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				// 旬食材絞り込み処理
				for (String tempdata : seasonFoodArrayList) { // 旬食材データから全て検索
					if (tempArrayList.get(12).equals(tempdata)) { // 合致する食材を検索
						recipeList.add(tempArrayList); // 合致したレシピを追加
					}
				}
			}

			// 絞り込み後データ表示(仮設)
			for (ArrayList<String> recipe : recipeList) {
				for (String data : recipe) {
					System.out.print(data + "\t");
				}
				System.out.println();
			}

			brFoo.close();
			brRec.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}