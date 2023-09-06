import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SushiEntry {

	public static void main(String[] args) {
		Scanner scn = new java.util.Scanner(System.in);
		Scanner scnS = new java.util.Scanner(System.in);

		//予約番号をキーとしてEntryInfoインスタンスを配列にもつMapのresave
		Map<String, EntryInfo> allResarve = new HashMap<>();

		while(true) {
			//メインメニュー表示
			showMainMenu(allResarve);

			//予約をするか確認する
			int input = scn.nextInt();

			if (input == 1) {
				System.out.println("■■  受　付  ■■");
				System.out.print("大人の人数を入力して下さい -> ");
				int inputAdult = scn.nextInt();

				System.out.print("子供の人数を入力して下さい -> ");
				int inputChild = scn.nextInt();

				System.out.println("座席の種類を入力して下さい");
				System.out.print("「ボックス席」ならBを「カウンター席」ならCを入力して下さい -> ");
				String inputTable = scnS.nextLine();
				System.out.println("");
				String resarveTable = inputTable.toUpperCase();
				if (resarveTable.equals("B")) {
					//入力がBならボックス席
					resarveTable = "ボックス席";
				} else if (resarveTable.equals("C")) {
					//入力がCならカウンター席
					resarveTable = "カウンター席";
				} else {
					//入力がそれ以外ならどちらでもよい
					resarveTable = "どちらでもよい";
				}

				//受け取った予約情報をインスタンス化
				EntryInfo resarve = new EntryInfo(inputAdult, inputChild, resarveTable);

				//予約情報を表示
				resarve.show();
				System.out.println("順次ご案内します");
				System.out.println("今しばらくお待ちくださいませ");

				//作ったインスタンスをArrayListに格納
				allResarve.put(resarve.getResarveNumber(), resarve);
			} else if (input == 2) {
				System.out.println("■■  キャンセル  ■■");
				System.out.print("受付番号を入力して下さい -> ");
				String inputResarveNumber = scnS.nextLine();
				EntryInfo cancelResarve = allResarve.get(inputResarveNumber);
				cancelResarve.show();
				System.out.println("キャンセルしますか？");
				System.out.print("「はい」ならYを「いいえ」ならNを入力して下さい ->");
				String CheckInput = scnS.nextLine();
				String cancelCheckInput = CheckInput.toUpperCase();
				if (cancelCheckInput.equals("Y")) {
					//Yが入力されたら指定された予約を削除
					allResarve.remove(inputResarveNumber);
					EntryInfo.cancel();
					System.out.println("キャンセルしました。またのご利用をお待ちしています");
					System.out.println("");
				} else {
					continue;
				}

			} else if (input == 9) {
				System.exit(0);
			}
		}

	}

	//メインメニュー表示のメソッド
	public static void showMainMenu(Map<String, EntryInfo> allResarve) {
		System.out.printf("<<現在%3d組待ちです>>",EntryInfo.waitingGroups);
		System.out.println();
		for (String rm : allResarve.keySet()) {
			System.out.println("  " + rm);
		}
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━┓");
		System.out.println("┃ 1:受付　2:キャンセル　9:終了 ┃");
		System.out.println("┗━━━━━━━━━━━━━━━┛");
	}

}
