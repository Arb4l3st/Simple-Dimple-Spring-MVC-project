package ru.arbalest.dao;

import ru.arbalest.models.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDAO {

    List<Company> getAllCompanies();
    Optional<Company> getCompanyByTIN(String tin);

    /**
     * @param companyName - Название организации
     * @param phoneNumber - Городской номер телефона
     * @param tin - ИНН органищации
     */
    void insertCompany(String companyName, String phoneNumber, String tin);
    void updateCompany(String companyName, String phoneNumber, String tin);
    void deleteCompanyByTIN(String tin);

}
