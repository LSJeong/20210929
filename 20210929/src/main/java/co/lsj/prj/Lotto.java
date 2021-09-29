package co.lsj.prj;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto {
	private Scanner scn = new Scanner(System.in);
	private int[] lotto = new int[6];

	private void menu() {
		System.out.println("   ***[Lotto]***    ");
		System.out.println("==1. 시작하기 2. 종료하기==");
		System.out.println("원하는 메뉴를 선택하세요>>");
	}

	private void mainMenu() {
		boolean b = true;

		do {
			menu();
			int choice = scn.nextInt();
			scn.nextLine();

			switch (choice) {
			case 1:
				money();
				break;
			case 2:
				System.out.println("종료하겠습니다.");
				b = false;
				break;
			default:
				System.out.println("잘못입력하였습니다.");
			}
		} while (b);
	}

	private void money() {
		System.out.println("금액을 입력하세요>>");
		int money2 = scn.nextInt();
		int won = money2 / 1000;
		int charge = money2 % 1000;
		
	
		for (int i = 1; i <= won; i++) {
			System.out.print("[" + i + "] ");
			game();
			if (i % 5 == 0) {
				System.out.println("======================");
			}
		}

		System.out.println("거스름돈은 : " + charge + "입니다.");
		
	}

	private void game() {

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}

		Arrays.sort(lotto);
//		int temp;
//		for (int i = 0; i < lotto.length - 1; i++) {
//			for (int j = i + 1; j < lotto.length; j++) {
//				if (lotto[i] > lotto[j]) {
//					temp = lotto[i];
//					lotto[i] = lotto[j];
//					lotto[j] = temp;
//				}
//			}
//		}

		for (int i = 0; i < lotto.length; i++) {
			System.out.printf("%d ", lotto[i]);
		}

		System.out.println();

	}

	public void start() {
		mainMenu();
		scn.close();
	}

}
