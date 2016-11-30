package UsersMock;

public abstract class UserMock {
    public abstract UserVO find(String id,UserType type);
    public abstract ResultMessage revoke(UserVO user);
}
