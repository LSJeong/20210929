package co.lsj.friend;

import java.util.Scanner;

public class DoWhileTest {
	private Scanner sc = new Scanner(System.in);
	private Friend[] friend = new Friend[100];

	private void mainMenu() {
		System.out.println("======ģ��======");
		System.out.println("== 1. �Է��ϱ� ==");
		System.out.println("== 2. �����ϱ� ==");
		System.out.println("== 3. ��ȸ�ϱ� ==");
		System.out.println("== 4. �����ϱ� ==");
		System.out.println("===============");
		System.out.println("���ϴ� �۾���ȣ�� �Է��ϼ���>>");
	}

	private void firstMenu() {
		System.out.println("===========================");
		System.out.println("== ����� �Է��ϴ� ȭ���Դϴ�. ==");
		System.out.println("�Է��� ģ���� ������>> 1��. �б����� 2��. ���嵿��");
		int choice = sc.nextInt();
		sc.nextLine();
		if (choice == 1 || choice == 2) {
			System.out.println("�̸� �Է��ϼ���>>");
			String name = sc.nextLine();
			System.out.println("����ó �Է��ϼ���>>");
			String phone = sc.nextLine();
			System.out.println("�ּ� �Է��ϼ���>>");
			String address = sc.nextLine();

			Friend person = null;

			if (choice == 1) {
				System.out.println("���� �Է��ϼ���>>");
				String major = sc.nextLine();
				person = new SchoolFriend(name, phone, address, major);
			} else if (choice == 2) {
				System.out.println("�μ� �Է��ϼ���>>");
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
			System.out.println("�߸��Է��ϼ̽��ϴ�.");
		}
	}

	private void secondMenu() {
		System.out.println("===========================");
		System.out.println("== ����� �����ϴ� ȭ���Դϴ�. ==");

		System.out.println("������ ģ���̸��� �Է�>>");
		String name = sc.nextLine();
		System.out.println("������ ��ȭ��ȣ�Է�(��������� Enter)>>");
		String phone = sc.nextLine();
		System.out.println("������ �ּ��Է�(��������� Enter)>>");
		String address = sc.nextLine();

		boolean b = false;

		for (int i = 0; i < friend.length; i++) {
			if (friend[i] != null && friend[i].getName().equals(name)) {
				if (!phone.equals(""))
					friend[i].setTel(phone);
				if (!address.equals(""))
					friend[i].setAddress(address);

				if (friend[i] instanceof SchoolFriend) {
					System.out.println("������ �����Է�(��������� Enter)>>");
					String major = sc.nextLine();
					if (!major.equals(""))
						((SchoolFriend) friend[i]).setMajor(major);

				} else if (friend[i] instanceof CompanyFriend) {
					System.out.println("������ �μ��Է�(��������� Enter)>>");
					String depart = sc.nextLine();
					if (!depart.equals(""))
						((CompanyFriend) friend[i]).setDepart(depart);
				}

				b = true;
			}
		}

		if (b) {
			System.out.println("�����Ϸ�!!!");
		} else {
			System.out.println("�����һ���� �����ϴ�. �̸��� ��Ȯ�� �Է��ϼ���.");
		}
	}

	private void thirdMenu() {
		System.out.println("===========================");
		System.out.println("== ����� ��ȸ�ϴ� ȭ���Դϴ�. ==");

		System.out.println("��ȸ�� ģ���̸��Է�(Enter�� �Է½� ��ü�˻�)>>");
		String name = sc.nextLine();
		System.out.println("��ȸ�� �ּ��Է�(Enter�� �Է½� ��ü�˻�)>>");
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
		boolean b = true; // ��κ� false�� �ʱ� ��

		friend[0] = new SchoolFriend("ȫ�浿", "010-111-222", "�뱸������ �߱�", "�İ�");
		friend[1] = new SchoolFriend("ȫ���", "010-333-444", "�뱸������ ����", "����");
		friend[2] = new SchoolFriend("��ö��", "010-555-666", "�뱸������ �޼���", "ȸ��");
		friend[3] = new CompanyFriend("��浿", "010-111-212", "����Ư���� �߱�", "�λ���");
		friend[4] = new CompanyFriend("�ڵѸ�", "010-777-555", "���������� �߱�", "�Ѻ���");
		friend[5] = new CompanyFriend("�����", "010-121-333", "��걤���� �߱�", "������");
		
		do {
			mainMenu();
			int key = sc.nextInt();
			sc.nextLine(); // ���� Ŭ���� ����
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
				b = false; // false �ʱⰪ�̸� true�� ����
				break;
			}
		} while (b); // false �ʱⰪ�̸� (!b)�� �����س���

	}

	public void run() {
		doWhileMenu();
		sc.close();
	}

}
