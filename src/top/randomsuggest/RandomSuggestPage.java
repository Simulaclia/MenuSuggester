package top.randomsuggest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomSuggestPage {
	public static void main(String[] args) {

		/*ランダム献立提案
		 *csvファイルから献立を取得　受け取った絞り込み条件を利用して絞り込み提案する
		 *絞り込み条件:ジャンル,調理法,2人前価格,料理所要時間,カロリー
		 *(今後条件が追加されても簡単に実装できる書き方にしてください。)
		 *絞り込みした結果を元に、ランダムで一品決定し、画面に出力します。<br>
		 *なお、決定した一品に関するデータはブックマーク保存時に利用できるようにしてください。
		 */

		//csvから取得⇒条件を取ってきて絞り込み
		//結果を元に「一品」出力　結果はブックマークに

		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br = null;

		//消しておく
		System.out.println("ジャンルを入力して下さい。");
		Scanner sc = new Scanner(System.in);
		String input_text = sc.nextLine();

		String genre = "中華";
		try {
			//ファイル名またはパスでcsv取得
			fi = new FileInputStream("csv/Recipe.csv");
			is = new InputStreamReader(fi);
			br = new BufferedReader(is);

			String tempData; // CSVファイル一行読み込みデータ
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>(); // 絞り込み後データ

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
				if (tempArrayList.get(1).equals(input_text)) { // 合致する食材を検索
					recipeList.add(tempArrayList); // 合致したレシピを追加
				}
			}

			// 絞り込み後データ表示(仮設)
			for (ArrayList<String> recipe : recipeList) {
				for (String data : recipe) {
					System.out.print(data + "\t");
				}
				System.out.println();
			}

			//			//読み込み行
			//			String line;
			//			//行数云々
			//			int i = 0;
			//			String[] arr = null;
			//			//一行ずつ
			//			while ((line = br.readLine()) != null) {
			//				//先頭行=列名:
			//				if (i == 0) {
			//					//arr={料理名,料理国,料理ジャンル,2人前価格,料理所要時間,カロリー,タンパク質量,脂質量,炭水化物量,
			//					//よく使われる主食材,料理の主食材,主食材,旬の食材,クックパッドの料理名検索リンク};
			//					arr = line.split(",");
			//
			//				} else {
			//					//内容表示
			//					System.out.println("-------------------");
			//					//件数名
			//					System.out.println("データ" + i + "件目");
			//					String[] data = line.split(",");
			//					//中身を順位表示　列数　
			//					int colno = 0;
			//					for (String column : arr) {
			//						System.out.println(column + ":" + data[colno]);
			//						colno++;
			//					}
			//				}
			//				//行数のインクリメント
			//				i++;
			//			}

			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
