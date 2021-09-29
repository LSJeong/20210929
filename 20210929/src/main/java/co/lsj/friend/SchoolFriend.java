package co.lsj.friend;

public class SchoolFriend extends Friend {
	private String major;
	
	public SchoolFriend(String name, String tel, String address, String major) {
		super(name, tel, address);
		this.major = major;
	}

	@Override
	public void friendPrint() {
		System.out.println("[이름: " + name + ", 전화번호: " + tel + ", 주소: " + address + ", 전공: " + major + ", 구분: 학교동기]");
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
}
