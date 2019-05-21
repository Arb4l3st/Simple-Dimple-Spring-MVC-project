package ru.arbalest.dao.mapper;

import ru.arbalest.models.OneUser;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserMapper implements RowMapper<OneUser> {

    @Override
    public OneUser mapRow(ResultSet rs, int rowNum) throws SQLException {
        OneUser company = new OneUser();
        company.setFio(rs.getString("fio"));
        company.setDateR(rs.getString("dater"));
        company.setEmail(rs.getString("email"));
        company.setCompanyName(rs.getString("companyname"));
        company.setId(rs.getInt("id"));
        return company;
    }
}