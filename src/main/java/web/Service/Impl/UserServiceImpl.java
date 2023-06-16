package web.Service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.Repository.UserRep;
import web.Service.UserService;
import web.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRep userRepS;

    public UserServiceImpl(UserRep userRepS) {
        this.userRepS = userRepS;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepS.getAllUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        userRepS.createUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user, Long id) {
        userRepS.updateUser(user, id);
    }

    @Override
    public User readUser(Long id) {
        return userRepS.readUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepS.deleteUser(id);
    }
}
