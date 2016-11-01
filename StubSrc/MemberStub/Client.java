package MemberStub;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberBLService_Stub memberBlService_Stub = new MemberBLService_Stub("Admin","1234","ะกร๗","8888");
		MemberBLService_Driver driver = new MemberBLService_Driver();
		driver.drive(memberBlService_Stub);
	}

}
