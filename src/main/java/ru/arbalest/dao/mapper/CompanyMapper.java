package ru.arbalest.dao.mapper;

import ru.arbalest.models.Company;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
/*
Преобразует данные, полученные из БД в объект Company.
 */
@Component
public class CompanyMapper implements RowMapper<Company> {

    @Override
    public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
        Company company = new Company();
        company.setTIN(rs.getString("tin"));
        company.setCompanyName(rs.getString("companyname"));
        company.setPhoneNumber(rs.getString("phonenumber"));
        return company;
    }

}