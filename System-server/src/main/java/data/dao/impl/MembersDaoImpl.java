package data.dao.impl;


import java.util.ArrayList;

import data.dao.MembersDao;
import data.dataHelper.DataFactory;
import data.dataHelper.MembersDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.CreditrecordPO;
import po.MemberPO;

public class MembersDaoImpl implements MembersDao{
	private static MembersDaoImpl membersDaoImpl;
	private static MembersDataHelper membersDataHelper;
	private DataFactory dataFactory;
	public MembersDaoImpl() {
		// TODO Auto-generated constructor stub
		dataFactory = new DataFactoryImpl();
        membersDataHelper =dataFactory.getMembersDataHelper();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		MembersDaoImpl membersdao = new MembersDaoImpl();
	}
	public static MembersDaoImpl getInstance(){
		if(membersDaoImpl ==null){
			membersDaoImpl = new MembersDaoImpl();
			return membersDaoImpl;
		}
		else{
			return membersDaoImpl;
		}
	}
	public MemberPO getMember(String id)  {//根据id查找用户信息
		// TODO Auto-generated method stub
		
		return  membersDataHelper.getMember(id);
	}



	public boolean updateCredit(String id, double changecredit) {
		// TODO Auto-generated method stub
		return membersDataHelper.updateMemberCredit(id, changecredit);
	}
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) {
		// TODO Auto-generated method stub
		return membersDataHelper.getMemberCreditRecord(memberid);
	}
	public void insertCreditRecord(CreditrecordPO po) {
		// TODO Auto-generated method stub
		membersDataHelper.insertCreditRecord(po);
	}

}