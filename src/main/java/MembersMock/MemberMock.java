package MembersMock;

import java.util.ArrayList;
import java.util.Date;

import po.MemberPO;



public class MemberMock {   
        //��Ա����õ���Ա��Ϣ
	String memberId;
    String memberPassword;
    String memberName;
    String memberTelephone;
    double credit;
    Date birthday;
    MemberControllerMock membercontroller;
        public MemberPO getMember(){
       	 return new MemberPO(memberId,memberPassword,memberName,memberTelephone,credit,birthday);
        }
       
        
        public void endRegister(){
       	 System.out.println("End the register");
        }
}

