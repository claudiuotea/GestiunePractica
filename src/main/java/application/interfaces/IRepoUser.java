package application.interfaces;

import application.Entities.User;

public interface IRepoUser {
    int addUser(User user);
    User findUser(User user);
    boolean findByUsername(String username);
    boolean findByEmail(String email);
}
