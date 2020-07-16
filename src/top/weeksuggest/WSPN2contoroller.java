package top.weeksuggest;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import top.TopPage;

public class WSPN2contoroller {

	//コンボボックスの読み込み
	@FXML
	private ComboBox<Integer> WACb, YOCb, CHUCb, price;

	// 一週間ランダム表示に戻る処理
	@FXML
	void backPage_button_OnClick(ActionEvent evt) {
		new TopPage().changePage("/top/weeksuggest/WSPage.fxml");
	}

	//コンボボックスに値を入れる
	@FXML
	void initialize() {
		//和食
		WACb.getItems().addAll(1, 2, 3, 4, 5, 6, 7);
		//洋食
		YOCb.getItems().addAll(1, 2, 3, 4, 5, 6, 7);
		//中華
		CHUCb.getItems().addAll(1, 2, 3, 4, 5, 6, 7);
		//値段（仮定）
		price.getItems().addAll(2500, 3500, 4000, 5000, 7500, 10000, 15000);

		WACb.setValue(null);
		YOCb.setValue(null);
		CHUCb.setValue(null);
		price.setValue(null);

	}

	@FXML
	protected void resetButton_OnClick(ActionEvent evt) {
		WACb.setValue(null);
		YOCb.setValue(null);
		CHUCb.setValue(null);
		price.setValue(null);

	}

	@FXML
	void decision_OnClick(ActionEvent evt) {

		new TopPage().changePage("/top/weeksuggest/WSPage.fxml");
	}

}
