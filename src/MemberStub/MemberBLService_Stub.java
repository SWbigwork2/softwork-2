package MemberStub;

import java.util.ArrayList;

public class MemberBLService_Stub implements MemberBLService{
         String memberName;
         String memberPassword;
         String memberId;
         String memberTelephone;
         public  MemberBLService_Stub(String memberId,String memberPassword,String memberName,String memberTelephone){
        	 this.memberId=memberId;
        	 this.memberName=memberName;
        	 this.memberPassword=memberPassword;
        	 this.memberTelephone=memberTelephone;
         }
         //��Ա����õ���Ա��Ϣ
         public MemberVO getMember(){
        	 return new MemberVO(memberId,memberPassword,memberName,memberTelephone);
         }
        
         public ArrayList<MemberVO> getMemberList(String memberId,String memberPassword,String memberName,String memberTelephone){
     		ArrayList<MemberVO> memberVOs = new ArrayList<MemberVO>();
     		memberVOs.add(new MemberVO(memberId,memberPassword,memberName,memberTelephone));
     		return memberVOs;
     	}
         //ִ��ע���Ա����
         public ResultMessage addMember(String id){
        	 if(id.equals("0001")){
        		 return ResultMessage.Failure;
        		
        	 } else return ResultMessage.Success;
        		
         }
         public void endRegister(){
        	 System.out.println("End the register");
         }
}
