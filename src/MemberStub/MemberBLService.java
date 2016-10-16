package MemberStub;

import java.util.ArrayList;

public interface MemberBLService {
	 public MemberVO getMember();
	 public ArrayList<MemberVO> getMemberList(String memberId,String memberPassword,String memberName,String memberTelephone);
	 public static ResultMessage addMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	 public static void endRegister() {
		// TODO Auto-generated method stub
		
	}
}
