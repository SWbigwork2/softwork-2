package UserDataStub;

public interface UserDataService {
	public void insert(UserPO UserPO);
	public void delet(UserPO UserPO);
	public void update(UserPO UserPO);
	public UserPO find(int UserId);	
}
