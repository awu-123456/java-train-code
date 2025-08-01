package user.factory;

import user.NormalUser;
import user.User;

public class NormalUserFactory implements IUserFactory{
    @Override
    public User createUser(String name, int userId) {
        return new NormalUser(name,userId);
    }
}
