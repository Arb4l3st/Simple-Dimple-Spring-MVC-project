package ru.arbalest.dao;

import ru.arbalest.models.OneUser;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    /**
     *
     * @return содержит либо объект, либо null, если объекта по такому ID не существует
     */
    Optional<OneUser> getUserById(int id);
    List<OneUser> getAllUsers();
    List<OneUser> getUsersByCompany(String companyName);
    /**
     *
     * @param fio - ФИО сотрудника
     * @param dater - Дата рождения сотрудника
     * @param email - email
     * @param companyName - Название компании в которой состоит сотрудник
     * @param id - Уникальный номер пользователя
     */
    void insertUser(String fio, String dater, String email, String companyName, int id);
    void updateUser(String fio, String dater, String email, String companyName, int id);
    void deleteUserById(int id);

}
