package data.memberTester;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.MembersDao;
import data.dao.impl.MembersDaoImpl;
import po.CreditrecordPO;

public class getMemberCreditRecordTest {

	@Test
	public void creditRecordtest() throws RemoteException {
		MembersDao dao=new MembersDaoImpl().getInstance();
		ArrayList<CreditrecordPO> testlist=new ArrayList<CreditrecordPO>();
		CreditrecordPO creditrecordPO=new CreditrecordPO("1001", "2016-10-24", 1002, "订单执行", 100, 200);
		testlist.add(creditrecordPO);
		assertTrue(isEqual(dao.getMemberCreditRecord("1001"),testlist));
	}

	private boolean isEqual(Object obj1,Object obj2){       //比较两个类是否相同
		Field[] f1 = obj1.getClass().getDeclaredFields();
		Field[] f2 = obj1.getClass().getDeclaredFields();
		for(int i=0;i<f1.length;i++){
			if(!f1[i].equals(f2[i])){
				return false;
			}
		}
		return true;
	}
}
