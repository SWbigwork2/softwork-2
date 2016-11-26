package data.memberTester;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.Date;

import org.junit.Test;

import data.dao.MembersDao;
import data.dao.impl.MembersDaoImpl;
import po.MemberPO;

public class updateCreditTester {
	MemberPO testpo=new MemberPO("1000", "王华","wanghua" , null, 100,new Date(1997,05,02));
	@Test
	public void updateCredittest() {
		MembersDao dao=new MembersDaoImpl().getInstance();
		assertTrue(dao.updateCredit("1000", 100));
		assertEquals(100, testpo.getCredit());
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
