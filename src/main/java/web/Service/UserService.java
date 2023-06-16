package web.Service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void createUser(User user);

    void updateUser(User user, Long id);

    User readUser(Long id);

    void deleteUser(Long id);
}
