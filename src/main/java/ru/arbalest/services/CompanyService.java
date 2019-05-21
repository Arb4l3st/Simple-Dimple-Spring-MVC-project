package ru.arbalest.services;

import ru.arbalest.models.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    Company getCompanyByTIN(String TIN);                                                                         //кот Шредингера
    void insertCompany(String companyName, String phoneNumber, String tin);
    void updateCompany(String companyName, String phoneNumber, String tin);
    void deleteCompany(String tin);

}
