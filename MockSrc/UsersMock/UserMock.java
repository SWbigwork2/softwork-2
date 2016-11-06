package UsersMock;

public abstract class UserMock {
    public abstract UserVO find(int id,UserType type);
    public abstract ResultMessage revoke(int id,UserVO user,UserType type);
}
