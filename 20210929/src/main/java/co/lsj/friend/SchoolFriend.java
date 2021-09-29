package co.lsj.friend;

public class SchoolFriend extends Friend {
	private String major;
	
	public SchoolFriend(String name, String tel, String address, String major) {
		super(name, tel, address);
		this.major = major;
	}

	@Override
	public void friendPrint() {
		System.out.println("[�̸�: " + name + ", ��ȭ��ȣ: " + tel + ", �ּ�: " + address + ", ����: " + major + ", ����: �б�����]");
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
}
