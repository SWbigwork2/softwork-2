package ordersblimpl;

public class MembersInfo  {
	int memberId;
	static String name;
	double credit;
	public MembersInfo(int memberId, String name, double credit) {
		this.memberId = memberId;
		this.name = name;
		this.credit = credit;
	}
	public static String getName(String memberId){
		return name;
	}
	public static String getMemberLevel(String userId){
		return null;
	}
}
