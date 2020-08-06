package top.weeksuggest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import top.TopPage;

public class WSPN2contoroller {

	// ラベルの取得
	@FXML
	private Label warning;

	// コンボボックスの読み込み
	@FXML
	private ComboBox<String> WACb, YOCb, CHUCb, price;

	// 一週間ランダム表示に戻る処理
	@FXML
	void backPage_button_OnClick(ActionEvent evt) {
		new TopPage().changePage("/top/weeksuggest/WSPage.fxml");
	}

	// コンボボックスに値を入れる
	@FXML
	void initialize() {
		// 和食
		WACb.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7");
		// 洋食
		YOCb.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7");
		// 中華
		CHUCb.getItems().addAll("0", "1", "2", "3", "4", "5", "6", "7");
		// 値段（仮定）
		price.getItems().addAll("3000", "3500", "4000", "4500", "5000", "5500", "6000", "6500", "7000");

		WACb.setValue("0");
		YOCb.setValue("0");
		CHUCb.setValue("0");
		price.setValue("7000");

	}

	@FXML
	protected void resetButton_OnClick(ActionEvent evt) {
		WACb.setValue("0");
		YOCb.setValue("0");
		CHUCb.setValue("0");
		price.setValue("7000");

	}

	static String[] delivery;// 絞り込みデータ受け渡し用の配列

	@FXML
	void decision_OnClick(ActionEvent evt) {

		int WACbInt = Integer.parseInt(WACb.getValue());
		int YOCbInt = Integer.parseInt(YOCb.getValue());
		int CHUCbInt = Integer.parseInt(CHUCb.getValue());

		if (WACbInt + YOCbInt + CHUCbInt != 7) {
			warning.setText("※合計が7品ではありません");
		} else {
			delivery = new String[] { WACb.getValue(), YOCb.getValue(), CHUCb.getValue(), price.getValue() };
			new TopPage().changePage("/top/weeksuggest/WSPage.fxml");
		}
	}

	public static String[] getdelivery() {
		return delivery;
	}

	public static void deletedelivery() {
		delivery = new String[] {};
	}

}
