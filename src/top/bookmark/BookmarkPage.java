package top.bookmark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BookmarkPage {

	public static ArrayList<ArrayList<String>> Bookmark() {
		try {
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
			BufferedReader brRec = new BufferedReader(isrRec);
			String tempData;
			ArrayList<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();

			while ((tempData = brRec.readLine()) != null) {
				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				bookmarkList.add(tempArrayList);
			}
			brRec.close();
			return bookmarkList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void addBookmark(ArrayList<String> recipe) {
		try {
			int count = 1;
			File file = new File("csv/Bookmark.csv");
			FileWriter filewriter = new FileWriter(file, true);
			for (String str : recipe) {
				if (count <= recipe.size() - 1)
					filewriter.write(str + ",");
				count++;
			}
			filewriter.write(recipe.get(recipe.size() - 1) + "\n");
			filewriter.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
