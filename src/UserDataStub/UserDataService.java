package UserDataStub;

import DataFactoryStub.DataService;

public interface UserDataService extends DataService{
	public void insert(UserPO UserPO);
	public void delet(UserPO UserPO);
	public void update(UserPO UserPO);
	public UserPO find(int UserId);	
}
