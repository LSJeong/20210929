package co.lsj.friend;

import java.util.Scanner;

public class DoWhileTest {
	private Scanner sc = new Scanner(System.in);
	private Friend[] friend = new Friend[100];

	private void mainMenu() {
		System.out.println("======친구======");
		System.out.println("== 1. 입력하기 ==");
		System.out.println("== 2. 수정하기 ==");
		System.out.println("== 3. 조회하기 ==");
		System.out.println("== 4. 종료하기 ==");
		System.out.println("===============");
		System.out.println("원하는 작업번호를 입력하세요>>");
	}

	private void firstMenu() {
		System.out.println("===========================");
		System.out.println("== 여기는 입력하는 화면입니다. ==");
		System.out.println("입력할 친구를 고르세요>> 1번. 학교동기 2번. 직장동료");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1 || choice == 2) {
			System.out.println("이름 입력하세요>>");
			String name = sc.nextLine();
			System.out.println("연락처 입력하세요>>");
			String phone = sc.nextLine();
			System.out.println("주소 입력하세요>>");
			String address = sc.nextLine();

			Friend person = null;

			if (choice == 1) {
				System.out.println("전공 입력하세요>>");
				String major = sc.nextLine();
				person = new SchoolFriend(name, phone, address, major);
			} else if (choice == 2) {
				System.out.println("부서 입력하세요>>");
				String depart = sc.nextLine();
				person = new CompanyFriend(name, phone, address, depart);
			}

			for (int i = 0; i < friend.length; i++) {
				if (friend[i] == null) {
					friend[i] = person;
					break;
				}
			}
		} else {
			System.out.println("잘못입력하셨습니다.");
		}
	}

	private void secondMenu() {
		System.out.println("===========================");
		System.out.println("== 여기는 수정하는 화면입니다. ==");

		System.out.println("수정할 친구이름을 입력>>");
		String name = sc.nextLine();
		System.out.println("수정할 전화번호입력(변경없을시 Enter)>>");
		String phone = sc.nextLine();
		System.out.println("수정할 주소입력(변경없을시 Enter)>>");
		String address = sc.nextLine();

		boolean b = false;

		for (int i = 0; i < friend.length; i++) {
			if (friend[i] != null && friend[i].getName().equals(name)) {
				if (!phone.equals(""))
					friend[i].setTel(phone);
				if (!address.equals(""))
					friend[i].setAddress(address);

				if (friend[i] instanceof SchoolFriend) {
					System.out.println("수정할 전공입력(변경없을시 Enter)>>");
					String major = sc.nextLine();
					if (!major.equals(""))
						((SchoolFriend) friend[i]).setMajor(major);

				} else if (friend[i] instanceof CompanyFriend) {
					System.out.println("수정할 부서입력(변경없을시 Enter)>>");
					String depart = sc.nextLine();
					if (!depart.equals(""))
						((CompanyFriend) friend[i]).setDepart(depart);
				}

				b = true;
			}
		}

		if (b) {
			System.out.println("수정완료!!!");
		} else {
			System.out.println("수정할사람이 없습니다. 이름을 정확히 입력하세요.");
		}
	}

	private void thirdMenu() {
		System.out.println("===========================");
		System.out.println("== 여기는 조회하는 화면입니다. ==");

		System.out.println("조회할 친구이름입력(Enter만 입력시 전체검색)>>");
		String name = sc.nextLine();
		System.out.println("조회할 주소입력(Enter만 입력시 전체검색)>>");
		String add = sc.nextLine();

		for (int i = 0; i < friend.length; i++) {
			if (!name.equals("") && !add.equals("")) {
				if (friend[i] != null && friend[i].getName().indexOf(name) != -1
						&& friend[i].getAddress().indexOf(add) != -1)
					friend[i].friendPrint();
			} else if (!name.equals("")) {
				if (friend[i] != null && friend[i].getName().indexOf(name) != -1)
					friend[i].friendPrint();
			} else if (!add.equals("")) {
				if (friend[i] != null && friend[i].getAddress().indexOf(add) != -1)
					friend[i].friendPrint();
			} else {
				if (friend[i] != null)
					friend[i].friendPrint();
			}
		}

	}

	private void endMenu() {
		System.out.println("=======Good Bye=======");
	}

	private void doWhileMenu() {
		boolean b = true; // 대부분 false로 초기 값

		friend[0] = new SchoolFriend("홍길동", "010-111-222", "대구광역시 중구", "컴공");
		friend[1] = new SchoolFriend("홍길순", "010-333-444", "대구광역시 서구", "전자");
		friend[2] = new SchoolFriend("김철수", "010-555-666", "대구광역시 달서구", "회계");
		friend[3] = new CompanyFriend("김길동", "010-111-212", "서울특별시 중구", "인사팀");
		friend[4] = new CompanyFriend("박둘리", "010-777-555", "대전광역시 중구", "총부팀");
		friend[5] = new CompanyFriend("최흥부", "010-121-333", "울산광역시 중구", "영업팀");
		
		do {
			mainMenu();
			int key = sc.nextInt();
			sc.nextLine(); // 버퍼 클리어 역할
			switch (key) {
			case 1:
				firstMenu();
				break;
			case 2:
				secondMenu();
				break;
			case 3:
				thirdMenu();
				break;
			case 4:
				endMenu();
				b = false; // false 초기값이면 true로 설정
				break;
			}
		} while (b); // false 초기값이면 (!b)로 설정해놓음

	}

	public void run() {
		doWhileMenu();
		sc.close();
	}

}
