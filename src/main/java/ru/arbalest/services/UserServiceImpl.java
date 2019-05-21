package ru.arbalest.services;

import ru.arbalest.exception.UserNotFoundException;
import ru.arbalest.dao.UserDAO;
import ru.arbalest.models.OneUser;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/*
выполнение бизнес-логики
 */
@Primary
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public OneUser getUserById(int id) {
        return userDAO.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public List<OneUser> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public List<OneUser> getUsersByCompany(String companyName) {
        return userDAO.getUsersByCompany(companyName);
    }

    @Override
    public void insertUser(String fio, String dater, String email, String companyName, int id) {
        userDAO.insertUser(fio, dater, email, companyName, id);
    }

    @Override
    public void updateUser(String fio, String dater, String email, String companyName, int id) {
        OneUser user = userDAO.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userDAO.updateUser(fio, dater, email, companyName, user.getId());
    }

    @Override
    public void deleteUserById(int id) {
        OneUser user = userDAO.getUserById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        userDAO.deleteUserById(user.getId());
    }

}
