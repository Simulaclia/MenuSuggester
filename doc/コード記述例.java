import java.util.Random; //ランダム

public class codeDescriptionExample {
	public static void main(String[] args) {
		// 配列内ランダム表示用ランダム
		Random rand = new Random();
		int randNum = rand.nextInt(3);

		String[] bankName = { "楽天銀行", "住信SBIネット銀行", "ジャパンネット銀行" };

		System.out.println(bankName[randNum]); // 銀行名ランダム表示
	}
}