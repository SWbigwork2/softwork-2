package data.memberTester;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import data.dao.MembersDao;
import data.dao.impl.MembersDaoImpl;
import po.CreditrecordPO;

public class insertCreditRecordTester {

	@Test
	public void insertCreditRecordtest() throws RemoteException {
		MembersDao dao=new MembersDaoImpl().getInstance();
		CreditrecordPO po=new CreditrecordPO("1001", "2016-10-24", 1002, "订单执行", 100, 200);
			dao.insertCreditRecord(po);
			
			assertEquals(2,dao.getMemberCreditRecord("1001").size());
	}

}
