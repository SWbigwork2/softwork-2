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
	/**
	 * @param id
	 * @return 得到会员信息
	 */
	public MemberPO getMember(String id)  {
		// TODO Auto-generated method stub
		
		return  membersDataHelper.getMember(id);
	}


	/**
	 * @param id，changecredit
	 * @return 更新会员信用
	 */
	public boolean updateCredit(String id, double changecredit) {
		// TODO Auto-generated method stub
		return membersDataHelper.updateMemberCredit(id, changecredit);
	}
	/**
	 * @param memberid
	 * @return 得到会员信用记录
	 */
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) {
		// TODO Auto-generated method stub
		return membersDataHelper.getMemberCreditRecord(memberid);
	}
	/**
	 * @param po
	 * @return 插入会员信用记录
	 */
	public void insertCreditRecord(CreditrecordPO po) {
		// TODO Auto-generated method stub
		membersDataHelper.insertCreditRecord(po);
	}

}
