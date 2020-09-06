package top.foodsearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FoodSearchPage {

	public static ArrayList<ArrayList<String>> FoodSearch() {

		// FSP_ans_Conから選択食材データを取得
		String[] MainFood = FSP_Controller.getSearchFoodData();// 例:じゃがいも
		// System.out.println(MainFood);

		try {
			// 読み込みファイルのインスタンス生成
			FileInputStream fis = new FileInputStream("csv/Recipe.csv");// ファイル名・場所を指定
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			String tempData;// Recipe.csv読み込み
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>();// Recipe.csv絞り込み後データ

			// レシピCSVファイル絞り込み処理
			while ((tempData = br.readLine()) != null) {// レシピ CSVループ
				String[] tempList = tempData.split(",");// CSVファイル一行分から","で分割して配列代入
				ArrayList<String> tempArrayList = new ArrayList<String>();// 1行代入用
				for (String tempLi : tempList) { // 配列内データをリストに代入
					tempArrayList.add(tempLi);
				}
				// 選択食材絞り込み
				if (tempArrayList.get(9).equals(MainFood[0])) { // 食材を比較・//例:じゃがいも=じゃがいも
					recipeList.add(tempArrayList);// 合致したレシピを追加
				}
			}
			// 絞り込み後データ表示(仮設)
			/*
			 * for (ArrayList<String> recipe : recipeList) { for (String data : recipe) {
			 * System.out.print(data + "\t"); } System.out.println(); }
			 */
			br.close();
			return recipeList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}