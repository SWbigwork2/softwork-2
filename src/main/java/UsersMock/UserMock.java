package UsersMock;

public abstract class UserMock {
    public abstract UserVO find(String id,UserType type);
    public abstract ResultMessage revoke(String id,UserVO user,UserType type);
}
