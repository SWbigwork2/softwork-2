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
         //会员界面得到会员信息
         public MemberVO getMember(){
        	 return new MemberVO(memberId,memberPassword,memberName,memberTelephone);
         }
        
         public ArrayList<MemberVO> getMemberList(String memberId,String memberPassword,String memberName,String memberTelephone){
     		ArrayList<MemberVO> memberVOs = new ArrayList<MemberVO>();
     		memberVOs.add(new MemberVO(memberId,memberPassword,memberName,memberTelephone));
     		return memberVOs;
     	}
         //执行注册会员步骤
         public ResultMessage addMember(String id){
        	 if(id.equals("0001")){
        		 return ResultMessage.Failure;
        		
        	 } else return ResultMessage.Success;
        		
         }
         public void endRegister(){
        	 System.out.println("End the register");
         }
}
