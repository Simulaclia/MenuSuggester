package top.seasonsearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;

public class SeasonSearchPage {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		String seasonFood = "ねぎ";

		try {
			// レシピCSVファイル読み込み処理
			FileInputStream fisRec = new FileInputStream("csv/Recipe.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
			BufferedReader brRec = new BufferedReader(isrRec);

			String tempData; // CSVファイル一行読み込みデータ
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>(); // 絞り込み後データ

			// 旬食材CSVファイル読み込み処理
			FileInputStream fisFoo = new FileInputStream("csv/FoodSeason.csv");
			InputStreamReader isrFoo = new InputStreamReader(fisFoo);
			BufferedReader brFoo = new BufferedReader(isrFoo);

			String tempFoodData; // CSVファイル一行読み込みデータ
			ArrayList<String> foodArrayList = new ArrayList<String>(); // 絞り込み後データ

			int i = 1;
			while ((tempFoodData = brFoo.readLine()) != null) { // CSVファイル内データの最後までループ
				i++;
				if (i == calendar.get(Calendar.MONTH) + 1 - 1) {
					String[] tempFoodList = tempFoodData.split(","); // CSVファイル一行分から","で分割して配列代入
					// 配列内データをリストに代入
					for (String tempFo : tempFoodList) {
						foodArrayList.add(tempFo);
					}
				}
			}

			// CSVファイルリスト代入
			while ((tempData = brRec.readLine()) != null) { // CSVファイル内データの最後までループ
				String[] tempList = tempData.split(","); // CSVファイル一行分から","で分割して配列代入
				ArrayList<String> tempArrayList = new ArrayList<String>();
				// 配列内データをリストに代入
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}

				for (String tempdata : foodArrayList) {
					if (tempArrayList.get(12).equals(tempdata)) {
						recipeList.add(tempArrayList); // 条件に合致したデータを代入
					}
				}

//				// 旬食材絞り込み
//				if (tempArrayList.get(12).equals(seasonFood)) {
//					recipeList.add(tempArrayList); // 条件に合致したデータを代入
//				}
			}

			// 絞り込み後データ表示
			for (ArrayList<String> recipe : recipeList) {
				for (String data : recipe) {
					System.out.print(data + "\t");
				}
				System.out.println();
			}

			brRec.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}