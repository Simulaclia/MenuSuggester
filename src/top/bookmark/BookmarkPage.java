package top.bookmark;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BookmarkPage {

	static void addBookmark() {

		try {
			File file = new File("csv/Bookmark.csv");
			FileWriter filewriter = new FileWriter(file, true);
			filewriter.write("東名高速,名神高速" + "\n");
			filewriter.close();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
