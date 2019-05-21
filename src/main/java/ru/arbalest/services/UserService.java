package ru.arbalest.services;

import ru.arbalest.models.OneUser;

import java.util.List;

public interface UserService {

    OneUser getUserById(int id);
    List<OneUser> getAllUsers();
    List<OneUser> getUsersByCompany(String companyName);
    void insertUser(String fio, String dater, String email, String companyName, int id);
    void updateUser(String fio, String dater, String email, String companyName, int id);
    void deleteUserById(int id);
}
