package MemberStub;

public class MemberBLService_Driver {
	public void drive(MemberBLService memberBlService){
		ResultMessage result=MemberBLService.addMember("0001");
		if(result==ResultMessage.Failure){
			System.out.println("Member exists");
		}else System.out.println("Success");
		MemberBLService.endRegister();
	}
	   
}
