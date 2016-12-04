package Usersblimpl;

public abstract class Userblimpl {
    public abstract UserVO find(String id,UserType type);
    public abstract ResultMessage revoke(UserVO user);
}
