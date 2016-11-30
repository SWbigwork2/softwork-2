package data.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import UsersMock.ResultMessage;
import po.MarketerPO;
import po.MemberInformationPO;
import po.StaffPO;
import po.UserPO;
import UsersMock.UserType;
import UsersMock.VipType;
import data.dao.UserDao;
import data.dataHelper.DataFactory;
import data.dataHelper.UserDataHelper;
import data.dataHelper.impl.DataFactoryImpl;

public class UserDaoImpl implements UserDao{
	
    private static UserDaoImpl userDaoImpl;
    private UserDataHelper userDataHelper;
    private DataFactory dataFactory;
    
    public UserDaoImpl(){
    	dataFactory=new DataFactoryImpl();
		userDataHelper=dataFactory.getUserDataHelper();
    }
    
    public static UserDaoImpl getInstance(){
    	if(userDaoImpl ==null){
    		userDaoImpl=new UserDaoImpl();
    		return userDaoImpl;
    	}else{
    		return userDaoImpl;
    	}
    }
    
    //找用户
	public UserPO findUser(String id, UserType type) throws SQLException{
		// TODO Auto-generated method stub
		UserPO userPO=null;
		ArrayList list=userDataHelper.findUser(id, type);
		if(list.size()==0){
			return null;
		}
		
		Map hm = (Map)list.get(0);
		
		switch (type){
		case member: userPO=this.Map2MemberPo(hm);return userPO;
		case staff:userPO=this.Map2StaffPo(hm);return userPO;
		case marketer:userPO=this.Map2MarketerPo(hm);return userPO;
		}
		return null;
	}
    
	//更新用户信息
	public ResultMessage updateUser(UserPO userPO) throws SQLException {
		// TODO Auto-generated method stub
		
		return userDataHelper.updateUser(userPO);
	}
    
	//添加用户
	public ResultMessage addUser(UserPO userPO) throws SQLException {
		// TODO Auto-generated method stub
		return userDataHelper.addUser(userPO);
	}
    
	private StaffPO Map2StaffPo(Map map) {    //将map里的数据转换成Staffpo
		Map hm = map;
		
		String name= (String) hm.get("name");
		 int userTempId=(Integer)hm.get("id");
		 String staffId=Integer.toString(userTempId);
		String password = (String) hm.get("password");
		String hotelName =(String) hm.get("hotelName");
		
	
		StaffPO po =new StaffPO(staffId, name, password, hotelName);
		return po;
	}
	

	private MemberInformationPO Map2MemberPo(Map map) {    //将map里的数据转换成Staffpo
		Map hm = map;
		
		String name= (String) hm.get("name");
		String memberId=(String ) hm.get("id");
		String password = (String) hm.get("password");
		String  ContactInformation=(String) hm.get("Contact information");
		String special=  (String )hm.get("special");
		double credit=(Double)hm.get("credit");
//		System.out.println(hm.get("type"));
        int type=Integer.parseInt(String.valueOf(hm.get("type")));  
        			
        		
        int level=Integer.parseInt(String.valueOf(hm.get("level")));  
        VipType vipType=null;
        if(type==0){
        	vipType=VipType.ConmmentVip;
        }else{
        	vipType=VipType.CompanyVip;
        }
        
		MemberInformationPO po =new MemberInformationPO(memberId, name, password, ContactInformation,credit,vipType,special,level);
		return po;
	}
	
	private MarketerPO Map2MarketerPo(Map map) {    //将map里的数据转换成Staffpo
		Map hm = map;
		
		String name= (String) hm.get("name");
		int userIdtemp = (Integer) hm.get("id");
		String staffId=Integer.toString(userIdtemp);		
	    String password =(String )hm.get("password");
		MarketerPO po =new MarketerPO(staffId, name, password);
		return po;
	}
	
}
