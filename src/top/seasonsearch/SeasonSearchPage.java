package top.seasonsearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SeasonSearchPage {
	public static void main(String[] args) {
		String seasonFood = "ねぎ";

		try {
			// CSVファイル読み込み処理
			FileInputStream fis = new FileInputStream("csv/Recipe.csv");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String tempData; // CSVファイル一行読み込みデータ
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>(); // 絞り込み後データ

			// CSVファイルリスト代入
			while ((tempData = br.readLine()) != null) { // CSVファイル内データの最後までループ
				String[] tempList = tempData.split(","); // CSVファイル一行分から","で分割して配列代入
				ArrayList<String> tempArrayList = new ArrayList<String>();
				// 配列内データをリストに代入
				for (int i = 0; i <= tempList.length - 1; i++) {
					tempArrayList.add(tempList[i]);
				}
				// 旬食材絞り込み
				if (tempArrayList.get(12).equals(seasonFood)) {
					recipeList.add(tempArrayList); // 条件に合致したデータを代入
				}
			}

			// 絞り込み後データ表示
			for (ArrayList<String> recipe : recipeList) {
				for (String data : recipe) {
					System.out.print(data + "\t");
				}
				System.out.println();
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}