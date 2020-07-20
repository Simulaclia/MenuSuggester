package top.weeksuggest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class WeekSuggestPage {

	//通常の処理
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

	//絞り込み条件有りの場合
	public static ArrayList<ArrayList<String>> Weeksuggest(String genre1, String genre2, String genre3,
			String price) {
		//ジャンル(国)分けするための二次元配列の宣言
		ArrayList<ArrayList<String>> Japanese_foodArray = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> Western_foodArray = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> ChineseArray = new ArrayList<ArrayList<String>>();
		//ジャンル(国)分けした後の絞り込み用配列の宣言
		//		ArrayList<ArrayList<String>> NarrowDownData = new ArrayList<ArrayList<String>>();

		try {
			FileInputStream fisRec = new FileInputStream("csv/Recipe.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
			BufferedReader brRec = new BufferedReader(isrRec);

			String tempData;
			ArrayList<ArrayList<String>> NarrowDownList = new ArrayList<ArrayList<String>>();

			Random rand = new Random();

			while ((tempData = brRec.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				// 絞り込み処理
				/*if ((tempArrayList.get(1).equals(genre1) || genre1.equals("選択なし")) // ジャンル絞り込み
						&& (tempArrayList.get(1).equals(genre2) || genre2.equals("選択なし")) // 料理国絞り込み
						&& (genre3.equals("選択なし") || (Integer.parseInt(tempArrayList.get(5)) <= (Integer.parseInt(genre3)))) // カロリー絞り込み
						&& (price.equals("選択なし")
								|| (Integer.parseInt(tempArrayList.get(3)) <= (Integer.parseInt(price)))) // 価格絞り込み
				) */

				switch (tempArrayList.get(1)) {
				case "和食":
					//和食だけの配列

					Japanese_foodArray.add(tempArrayList);
					break;
				case "洋食":
					//洋食だけの配列

					Western_foodArray.add(tempArrayList);
					break;
				case "中華":
					//中華だけの配列

					ChineseArray.add(tempArrayList);
					break;
				}

			}

			for (int i = 1; i <= Integer.parseInt(genre1); i++) {
				int randomValue = rand.nextInt(Japanese_foodArray.size());
				NarrowDownList.add(Japanese_foodArray.get(randomValue));
				Japanese_foodArray.remove(randomValue);
			}

			for (int i = 1; i <= Integer.parseInt(genre2); i++) {
				int randomValue = rand.nextInt(Western_foodArray.size());
				NarrowDownList.add(Western_foodArray.get(randomValue));
				Western_foodArray.remove(randomValue);
			}
			for (int i = 1; i <= Integer.parseInt(genre3); i++) {
				int randomValue = rand.nextInt(ChineseArray.size());
				NarrowDownList.add(ChineseArray.get(randomValue));
				ChineseArray.remove(randomValue);
			}

			//NarrowDownList.addAll(NarrowDownData);

			brRec.close();
			return NarrowDownList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
