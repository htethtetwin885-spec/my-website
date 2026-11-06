package teamwork01;

import java.util.Scanner;

public class test01 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int[] seats = new int[50];
		int choice;
		int totalSales = 0;
		int price = 0;

		System.out.println("...座席予約システム...");

		while (true) {
			System.out.println("1.空席状況を確認する");
			System.out.println("2.座席を予約する");
			System.out.println("3.予約をキャンセルする");
			System.out.println("4.終了する");

			System.out.println("メニュー番号を入力してください");

			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("スクリーン画面");
				System.out.println("[0]=空席 , [X]=予約済");
				System.out.println("------------------------------");

				for (int i = 0; i < seats.length; i++) {
					int seatNumber = i + 1;
					String seatStr;
					if (seatNumber < 10) {
						seatStr = " " + seatNumber;
					} else {
						seatStr = "" + seatNumber;
					}
					if (seats[i] == 0) {
						System.out.print("[" + seatStr + ": 0] ");

					} else {
						System.out.print("[" + seatStr + ": X] ");
					}
					if (seatNumber % 5 == 0) {
						System.out.println();
					}
				}
				System.out.println("--------------------------------");

			} else if (choice == 2) {
				System.out.println("予約したい座席番号を入力してください（1-50）");
				int seatNum = scanner.nextInt();
				if (seatNum < 1 || seatNum > 50) {
					System.out.println("エラー：1から50までの数字を入力してください");
				} else {
					int k = seatNum - 1;
					if (seats[k] == 0) {
						if (seatNum <= 20) {
							price = 5000;
						} else if (seatNum <= 40) {
							price = 7000;
						} else {
							price = 10000;
						}
						System.out.println("座席の値段は" + price + "円です。");
						System.out.println("払いますか? 1:yes 2:no");
						int confirm = scanner.nextInt();
						if (confirm == 1) {
							seats[k] = 1;
							totalSales += price;
							System.out.println("座席番号(" + seatNum + ")の予約が完了しました。");

						} else {
							System.out.println("お支払い： キャンセルしました。");
							System.out.println("-------------------------------");
						}
					} else {
						System.out.println("申し訳ございません。この座席は予約されています。");
					}
				}
			} else if (choice == 3) {

				System.out.println("キャンセルしたい座席番号を入力してください（1-50）");
				int seatNum = scanner.nextInt();
				if (seatNum < 1 || seatNum > 50) {
					System.out.println("エラー：1から50までの数字を入力してください");

				} else {
					int k = seatNum - 1;
					if (seats[k] == 1) {
						if (seatNum <= 20) {
							price = 5000;
						} else if (seatNum <= 40) {
							price = 7000;
						} else {
							price = 10000;
						}
					}
					seats[k] = 0;
					totalSales -= price;
					System.out.println("座席番号(" + seatNum + ")の予約をキャンセルしました。");
					{
						System.out.println("この座席はまだ予約されていません。（空席です。）");
						System.out.println("-----------------------------");
					}
				}
			} else if (choice == 4) {
				System.out.println("---Daily Sale Report");
				System.out.println("今日の売上は" + totalSales + "円です。");
				System.out.println("----------------------------");
				System.out.println("システムを終了します。ご利用ありがとうございます。");
				break;
			} else {
				System.out.println("エラー：1から4までの数字を入力してください");
			}
		}
	}
}
