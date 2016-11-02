package MemberDataStub;

import java.util.ArrayList;

import DataFactoryStub.DataService;

public interface MemberDataService extends DataService{
	public void insert(MemberPO memberPO);
	public void delete(MemberPO memberPO);
	public void update(MemberPO memberPO);
	public MemberPO find(String Id);
	public ArrayList<MemberPO> findMemberList(String i,String n,String p,String t);
	

}