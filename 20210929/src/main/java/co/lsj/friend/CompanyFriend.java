package co.lsj.friend;

public class CompanyFriend extends Friend {
	private String depart;
	
	public CompanyFriend(String name, String tel, String address, String depart) {
		super(name, tel, address);
		this.depart = depart;
		
	}

	@Override
	public void friendPrint() {
		System.out.println("[�̸�: " + name + ", ��ȭ��ȣ: " + tel + ", �ּ�: " + address + ", �μ�: " + depart +", ����: ���嵿��]");
	
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}


	
}
