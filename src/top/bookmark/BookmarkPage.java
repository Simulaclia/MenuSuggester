package top.bookmark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BookmarkPage {

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
