package UserDataStub;

import UserStub.UserType;

public class UserDataService_Drive {	
	public void drive(UserDataService UsersDataService){
			UserPO po = new UserPO(0001, "ะกร๗","0001",UserType.staff, "qitian");
			UserPO findPo = UsersDataService.find(0001);
			if(findPo.equals(null)){
				System.out.println("User doesn't exist");
			}
			else{
				System.out.println("User exists");
			}
			UsersDataService.delet(po);
			UsersDataService.insert(po);
			UsersDataService.update(po);
		}

}
