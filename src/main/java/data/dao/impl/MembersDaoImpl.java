package data.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import Membersblimpl.ResultMessage;
import data.dao.MembersDataService;
import data.dataHelper.DataFactory;
import data.dataHelper.MembersDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import data.dataservice.MembersDao;
import data.rmi.RemoteHelper;
import po.CreditrecordPO;
import po.MemberPO;

public class MembersDaoImpl implements MembersDataService{
	private static MembersDaoImpl membersDaoImpl;
	private static MembersDataHelper membersDataHelper;
	private DataFactory dataFactory;
	private RemoteHelper remoteHelper;
	private MembersDao membersDao;
	public MembersDaoImpl() {
		remoteHelper = RemoteHelper.getInstance();
		membersDao = remoteHelper.getMembersDao();
		// TODO Auto-generated constructor stub
		dataFactory = new DataFactoryImpl();
        membersDataHelper =dataFactory.getMembersDataHelper();
		// TODO Auto-generated constructor stub
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
		return membersDao.getMember(id);
		//return  membersDataHelper.getMember(id);
	}



	public boolean updateCredit(String id, double changecredit) {
		// TODO Auto-generated method stub
		return membersDao.updateCredit(id, changecredit);
		//return membersDataHelper.updateMemberCredit(id, changecredit);
	}
	@Override
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) {
		// TODO Auto-generated method stub
		return membersDao.getMemberCreditRecord(memberid);
		//return membersDataHelper.getMemberCreditRecord(memberid);
	}
	@Override
	public void insertCreditRecord(CreditrecordPO po) {
		// TODO Auto-generated method stub
		membersDao.insertCreditRecord(po);
		//membersDataHelper.insertCreditRecord(po);
	}

}
