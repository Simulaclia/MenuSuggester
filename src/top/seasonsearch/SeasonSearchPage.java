package top.seasonsearch;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SeasonSearchPage {
	public static void main(String[] args) {

		try {
			FileInputStream fis = new FileInputStream("csv/Recipe.csv");
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);

			String tempData;
			ArrayList<ArrayList<String>> recipeList = new ArrayList<ArrayList<String>>();

			int i = 0;
			while ((tempData = br.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (int j = 0; j <= tempList.length - 1; j++) {
					tempArrayList.add(tempList[j]);
				}
				if (tempArrayList.get(12).equals("ねぎ")) {
					recipeList.add(tempArrayList);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}