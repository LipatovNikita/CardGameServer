package cardgame.service.impl;

import cardgame.bean.User;
import cardgame.repository.UserRepository;
import cardgame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(User user) {
        return userRepository.findByEmailAndIsActive(user.getEmail(), true);
    }

    @Override
    public User editUser(User user) {
        return userRepository.save(user);
    }
}