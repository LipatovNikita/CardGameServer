package cardgame.service;


import cardgame.bean.User;

public interface UserService {
    User registerUser(User user);
    User getUserByEmail(User user);
    User editUser(User user);
}
