package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDAO;
import web.models.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<User> findAll() {
        return userDAO.index();
    }

    public User findOne(int id) {
        Optional<User> foundUser = Optional.ofNullable(userDAO.show(id));
        return foundUser.orElse(null);
    }

    @Transactional
    public void save(User user) {
        userDAO.save(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        userDAO.update(id,updatedUser);
    }

    @Transactional
    public void delete(int id) {
        userDAO.delete(id);
    }
}
