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

	public static void AddBookmark(ArrayList<String> recipe) {
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
			e.printStackTrace();
		}
	}

	public static void DeleteBookmark(ArrayList<String> recipe) {
		try {
			ArrayList<ArrayList<String>> bookmarkList = new ArrayList<ArrayList<String>>();
			FileInputStream fisRec = new FileInputStream("csv/Bookmark.csv");
			InputStreamReader isrRec = new InputStreamReader(fisRec);
			BufferedReader brRec = new BufferedReader(isrRec);
			String tempData;

			while ((tempData = brRec.readLine()) != null) {

				String[] tempList = tempData.split(",");
				ArrayList<String> tempArrayList = new ArrayList<String>();
				for (String tempLi : tempList) {
					tempArrayList.add(tempLi);
				}
				if (!(recipe.get(0).equals(tempArrayList.get(0)) && recipe.get(8).equals(tempArrayList.get(8)))) {
					bookmarkList.add(tempArrayList);
				}
			}

			brRec.close();

			File file = new File("csv/Bookmark.csv");
			FileWriter filewriter = new FileWriter(file, false);
			filewriter.write("");
			filewriter.close();

			for (ArrayList<String> list : bookmarkList) {
				AddBookmark(list);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
