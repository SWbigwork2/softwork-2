package MemberDataStub;

public class MemberDataService_Driver {
	public void drive(MemberDataService memberDataService){
		MemberPO po = new MemberPO("Admin","1234","ะกร๗","8888");
		MemberPO findPo = memberDataService.find("0001");
		if(findPo.equals(null)){
			System.out.println("member doesn't exist");
		}
		else{
			System.out.println("member exists");
		}
		
		memberDataService.delete(po);
		memberDataService.insert(po);
		memberDataService.update(po);
	}
}
