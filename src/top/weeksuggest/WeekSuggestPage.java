package top.weeksuggest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class WeekSuggestPage {

	// リンク先に飛んだ際のランダムに表示した物を一時的に保存しておく配列
	static ArrayList<ArrayList<String>> temporaryfood = new ArrayList<ArrayList<String>>();

	public static void Settemporaryfood(ArrayList<ArrayList<String>> foodList) {
		temporaryfood = foodList;
	}

	public static ArrayList<ArrayList<String>> Gettemporaryfood() {
		return temporaryfood;
	}

	public static void Cleartemporaryfood() {
		temporaryfood.clear();
	}

	// 通常の処理
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

	// 絞り込み条件有りの場合
	public static ArrayList<ArrayList<String>> Weeksuggest(String genre1, String genre2, String genre3, String price) {
		// ジャンル(国)分けするための二次元配列の宣言
		ArrayList<ArrayList<String>> Japanese_foodArray = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> Western_foodArray = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> ChineseArray = new ArrayList<ArrayList<String>>();
		// ジャンル(国)分けした後の絞り込み用配列の宣言
		// ArrayList<ArrayList<String>> NarrowDownData = new
		// ArrayList<ArrayList<String>>();

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

				switch (tempArrayList.get(1)) {
				case "和食":
					// 和食だけの配列

					Japanese_foodArray.add(tempArrayList);
					break;
				case "洋食":
					// 洋食だけの配列

					Western_foodArray.add(tempArrayList);
					break;
				case "中華":
					// 中華だけの配列

					ChineseArray.add(tempArrayList);
					break;
				}

			}

			for (int i = 1; i <= Integer.parseInt(genre1); i++) {
				int randomValue = rand.nextInt(Japanese_foodArray.size());
				int k = Integer.parseInt(price) / 7;
				//System.out.println(Japanese_foodArray.get(randomValue).get(3));
				if (k < Integer.parseInt(Japanese_foodArray.get(randomValue).get(3))) {
					i--;
					continue;
				}
				NarrowDownList.add(Japanese_foodArray.get(randomValue));
				// System.out.println(Japanese_foodArray.get(randomValue).get(0));

				Japanese_foodArray.remove(randomValue);

			}
			for (int i = 1; i <= Integer.parseInt(genre2); i++) {
				int randomValue = rand.nextInt(Western_foodArray.size());
				int k = Integer.parseInt(price) / 7;
				//System.out.println(Western_foodArray.get(randomValue).get(3));
				if (k < Integer.parseInt(Western_foodArray.get(randomValue).get(3))) {
					i--;
					continue;
				}
				NarrowDownList.add(Western_foodArray.get(randomValue));
				// System.out.println(Western_foodArray.get(randomValue).get(0));
				Western_foodArray.remove(randomValue);

			}
			for (int i = 1; i <= Integer.parseInt(genre3); i++) {
				int randomValue = rand.nextInt(ChineseArray.size());
				int k = Integer.parseInt(price) / 7;
				//System.out.println(ChineseArray.get(randomValue).get(3));
				if (k < Integer.parseInt(ChineseArray.get(randomValue).get(3))) {
					i--;
					continue;
				}
				NarrowDownList.add(ChineseArray.get(randomValue));
				// System.out.println(ChineseArray.get(randomValue).get(0));
				ChineseArray.remove(randomValue);

			}
			genre1 = "0";
			genre2 = "0";
			genre3 = "0";

			// NarrowDownList.addAll(NarrowDownData);

			brRec.close();
			return NarrowDownList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
