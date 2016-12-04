package loginblimpl;

import UsersMock.UserType;

public class LoginVo {
	private UserType type;
	private String id;
	private String name;
	private String level;
	public LoginVo(UserType type, String id, String name, String level) {
		this.type = type;
		this.id = id;
		this.name = name;
		this.level = level;
	}
	public UserType getType() {
		return type;
	}
	public void setType(UserType type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	

}
