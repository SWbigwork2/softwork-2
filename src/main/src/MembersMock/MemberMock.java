package MembersMock;

import java.util.ArrayList;



public class MemberMock {   
        //会员界面得到会员信息
	String memberId;
    String memberPassword;
    String memberName;
    String memberTelephone;
    double credit;
    MemberControllerMock membercontroller;
        public MemberPO getMember(){
       	 return new MemberPO(memberId,memberPassword,memberName,memberTelephone,credit);
        }
       
        //执行注册会员步骤
        public ResultMessage addMember(String id){
        	
			return membercontroller.addmember(memberId, memberPassword, memberName, memberTelephone);
              
       		
        }
        
        public void endRegister(){
       	 System.out.println("End the register");
        }
}

