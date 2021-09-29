package co.lsj.friend;

public class CompanyFriend extends Friend {
	private String depart;
	
	public CompanyFriend(String name, String tel, String address, String depart) {
		super(name, tel, address);
		this.depart = depart;
		
	}

	@Override
	public void friendPrint() {
		System.out.println("[이름: " + name + ", 전화번호: " + tel + ", 주소: " + address + ", 부서: " + depart +", 구분: 직장동료]");
	
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}


	
}
