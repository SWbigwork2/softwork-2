package Usersblimpl;

public  class UserVO {
   
	String userId;
    String password;
    String name;
    String  type;
    
    public UserVO(String userId,String name,String password,String  type){
    	this.userId=userId;
    	this.name=name;
    	this.password=password;
    	this.type=type;
    }
    
    public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String  getType() {
		return type;
	}

	public void setType(String  type) {
		this.type = type;
	}

	
	

    
}
