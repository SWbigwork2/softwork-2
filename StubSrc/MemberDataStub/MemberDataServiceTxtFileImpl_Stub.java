package MemberDataStub;

import java.util.ArrayList;

public class MemberDataServiceTxtFileImpl_Stub implements MemberDataService {
	public MemberDataServiceTxtFileImpl_Stub() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void insert(MemberPO memberPO) {
		// TODO Auto-generated method stub
		System.out.println("Insert succeed");
	}

	@Override
	public void delete(MemberPO memberPO) {
		// TODO Auto-generated method stub
		System.out.println("Delet succeed");
	}

	@Override
	public void update(MemberPO memberPO) {
		// TODO Auto-generated method stub
		System.out.println("Update succeed");
	}

	@Override
	public MemberPO find(String Id) {
		// TODO Auto-generated method stub
		return new MemberPO("admin","1234","小明","8888");
	}

	@Override
	public ArrayList<MemberPO> findMemberList(String memberId,String memberPassword,String memberName,String memberTelephone) {
		ArrayList<MemberPO> memberList = new ArrayList<MemberPO>();
		MemberPO po = new MemberPO("admin","1234","小明","8888");
		memberList.add(po);
		// TODO Auto-generated method stub
		return memberList;
	}
}
