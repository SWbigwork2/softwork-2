package UserDataStub;

import UserStub.UserType;

public class UserDataServiceMysqlImpl_Stub implements UserDataService{

	@Override
	public void insert(UserPO UserPO) {
		// TODO Auto-generated method stub
		System.out.println("insert succeed");
	}

	@Override
	public void delet(UserPO UserPO) {
		// TODO Auto-generated method stub
		System.out.println("delet succeed");
	}

	@Override
	public void update(UserPO UserPO) {
		// TODO Auto-generated method stub
		System.out.println("update succeed");
	}

	@Override
	public UserPO find(int UserId) {
		// TODO Auto-generated method stub
		return new UserPO(0001, "ะกร๗","0001",UserType.staff, "qitian");
	}

}
