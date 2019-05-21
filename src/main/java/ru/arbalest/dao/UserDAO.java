package ru.arbalest.dao;

import ru.arbalest.models.OneUser;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    Optional<OneUser> getUserById(int id);
    List<OneUser> getAllUsers();
    List<OneUser> getUsersByCompany(String companyName);
    void insertUser(String fio, String dater, String email, String companyName, int id);
    void updateUser(String fio, String dater, String email, String companyName, int id);
    void deleteUserById(int id);

}
