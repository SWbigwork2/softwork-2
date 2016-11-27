package data.memberTester;

import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.Date;

import data.dao.MembersDao;
import data.dao.impl.MembersDaoImpl;
import po.MemberInformationPO;
import po.MemberPO;

public class getMemberTester {
	MemberPO testpo=new MemberPO("1000", "王华","wanghua" , null, 100,new Date(1997,05,02));
	/*@Test
	
	public void getMembertest() throws SQLException {
	 MembersDao dao =MembersDaoImpl.getInstance();
	 MemberInformationPO po=dao.getMember("1000");
	 assertTrue(isEqual(po, testpo));
	}*/
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
