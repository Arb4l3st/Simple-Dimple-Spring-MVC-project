package ru.arbalest.services;

import ru.arbalest.exception.CompanyNotFoundException;
import ru.arbalest.dao.CompanyDAO;
import ru.arbalest.models.Company;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/*
выполнение бизнес-логики
 */
@Primary
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyDAO companyDAO;

    public CompanyServiceImpl(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyDAO.getAllCompanies();
    }

    @Override
    public Company getCompanyByTIN(String tin) {
        return companyDAO.getCompanyByTIN(tin)
                .orElseThrow(() -> new CompanyNotFoundException(tin));
    }

    @Override
    public void insertCompany(String companyName, String phoneNumber, String tin) {
        companyDAO.insertCompany(companyName, phoneNumber, tin);
    }

    @Override
    public void updateCompany(String companyName, String phoneNumber, String tin) {
        Company company = companyDAO.getCompanyByTIN(tin)
                .orElseThrow(() -> new CompanyNotFoundException(tin));
        companyDAO.updateCompany(companyName, phoneNumber, company.getTIN());
    }

    @Override
    public void deleteCompany(String tin) {
        Company company = companyDAO.getCompanyByTIN(tin)
                .orElseThrow(() -> new CompanyNotFoundException(tin));
        companyDAO.deleteCompanyByTIN(company.getTIN());
    }

}
