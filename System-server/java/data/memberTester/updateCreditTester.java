package data.memberTester;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.sql.SQLException;

import org.junit.Test;

import data.dao.MembersDataService;
import data.dao.impl.MembersDaoImpl;
import po.MemberPO;

public class updateCreditTester {
	MemberPO testpo=new MemberPO("1000", "王华","wanghua" , null, 100,"1997-05-02",0,2);
	@Test
	public void updateCredittest() throws SQLException {
		MembersDataService dao=new MembersDaoImpl().getInstance();
		assertTrue(dao.updateCredit("1000", 100));
		assertTrue(isEqual(dao.getMember("1000"), testpo));
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
