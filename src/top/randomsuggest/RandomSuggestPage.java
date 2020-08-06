package top.randomsuggest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class RandomSuggestPage {
	// public static
	public static ArrayList<ArrayList<String>> Randomsuggest() {

		/*ランダム献立提案
		 *csvファイルから献立を取得　受け取った絞り込み条件を利用して絞り込み提案する
		 *絞り込み条件:ジャンル,調理法,2人前価格,料理所要時間,カロリー
		 *(今後条件が追加されても簡単に実装できる書き方にしてください。)
		 *絞り込みした結果を元に、ランダムで一品決定し、画面に出力します。
		 *なお、決定した一品に関するデータはブックマーク保存時に利用できるようにしてください。
		 */

		//Scanner sc = new Scanner(System.in);
		//String input_text = sc.nextLine();
		//String genre = "中華";

		/*使用する配列、データ等
		 *絞り込み=StrNarrowDate
		 */
		/*
		 * 		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;
		 *
		 *
		 * 			fi = new FileInputStream("csv/Recipe.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);
		 */

		try {

			//ファイル名またはパスでcsv取得

			FileInputStream fi = new FileInputStream("csv/Recipe.csv");
			InputStreamReader is = new InputStreamReader(fi);
			BufferedReader br = new BufferedReader(is);

			// CSVファイル一行読み込みデータ
			String tempData;

			// 絞り込み後データ
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>();

			// レシピCSVファイル絞り込み処理
			while ((tempData = br.readLine()) != null) { // CSVファイル内データの最後までループ
				String[] tempList = tempData.split(","); // CSVファイル一行分から","で分割して配列代入
				ArrayList<String> tempArrayList = new ArrayList<String>(); // 1行代入用
				// 配列内データをリストに代入
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}

				// 食材絞り込み処理
				//if (tempArrayList.get(1).equals(genre)) {
				//多分ここの()にジャンル枠の配列名を書く
				if (tempArrayList.get(1).equals(tempData)) { // 合致する食材を検索
					recipeList.add(tempArrayList); // 合致したレシピを追加
				}
			}

			/*
			// 絞り込み後データ表示(仮設)
			for (ArrayList<String> recipe : recipeList) {
				for (String data : recipe) {
					System.out.print(data + "\t");
				}
				System.out.println();
			}
			*/

			br.close();
			return recipeList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				//fi.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return null;

	}
}
