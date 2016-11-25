package MembersMock;

import java.util.ArrayList;

import po.MemberPO;



public class MemberMock {   
        //��Ա����õ���Ա��Ϣ
	String memberId;
    String memberPassword;
    String memberName;
    String memberTelephone;
    double credit;
    MemberControllerMock membercontroller;
        public MemberPO getMember(){
       	 return new MemberPO(memberId,memberPassword,memberName,memberTelephone,credit);
        }
       
        //ִ��ע���Ա����
        public ResultMessage addMember(String id){
        	
			return membercontroller.addmember(memberId, memberPassword, memberName, memberTelephone);
              
       		
        }
        
        public void endRegister(){
       	 System.out.println("End the register");
        }
}

