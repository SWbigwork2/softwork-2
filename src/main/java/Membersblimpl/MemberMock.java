package Membersblimpl;

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
    String special;
    int type;
    int level;
    MemberControllerMock membercontroller;
        public MemberPO getMember(){
       	 return new MemberPO(memberId,memberName,memberPassword,memberTelephone,credit,special, type, level);
        }
       
        
        public void endRegister(){
       	 System.out.println("End the register");
        }
}

