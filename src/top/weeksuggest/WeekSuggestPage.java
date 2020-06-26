package top.weeksuggest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class WeekSuggestPage {
	public static void main(String[] args) {

		/* adress = 読み込みたいテキストファイルがある場所。
		 */

		//配列[ノード番号][ノードの要素]の配列を準備
		//		int Index[][] = new int[100][100];
		String[][] recipe = new String[100][100];

		//ファイルの読み込み
		try {
			//ファイルのアドレスよりbrにファイルの情報を格納
			FileReader filereader = new FileReader("csv/Recipe.csv");
			BufferedReader br = new BufferedReader(filereader);

			//一行ずつ読み込んで
			String str = br.readLine();
			int count = 0;

			while (str != null) {
				//strlist.add(str.split(","));
				//一行の内容を','で分割してそれぞれを[count=ノード番号]の２次元目の配列の要素として格納
				String[] strArray = (str.split(","));
				int count2 = 0;
				for (String temp : strArray) {
					recipe[count][count2] = temp;
					count2++;
				}
				//次の行を読み込み
				str = br.readLine();
				count++;
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}

		//Recipeからランダムで表示
		Random random = new Random();

		for (int i = 0; i <= 6; i++) {
			int randomValue = random.nextInt(70);

			for (int j = 0; j <= 13; j++) {
				System.out.println(recipe[randomValue][j]);
			}
		}

		//		return Index;

	}

	/*  public void RandomExtraction(String[] R) {
	
	}*/
}
