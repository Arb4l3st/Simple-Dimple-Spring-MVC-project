package ru.arbalest.dao;

import ru.arbalest.models.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyDAO {

    List<Company> getAllCompanies();
    Optional<Company> getCompanyByTIN(String tin);
    void insertCompany(String companyName, String phoneNumber, String tin);
    void updateCompany(String companyName, String phoneNumber, String tin);
    void deleteCompanyByTIN(String tin);

}
