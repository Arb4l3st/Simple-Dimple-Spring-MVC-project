package ru.arbalest.dao;

import ru.arbalest.dao.mapper.CompanyMapper;
import ru.arbalest.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompanyDaoImpl implements CompanyDAO {

    private static final String SQL_GET_ALL_COMPANIES =
            "select * from companies";
    private static final String SQL_GET_COMPANY_BY_TIN =
            "select companyname, tin, phonenumber from companies where companies.tin = :tin";
    private static final String SQL_INSERT_COMPANY =
            "insert into companies (companyname, tin, phonenumber) values (:companyname, :tin, :phonenumber)";
    private static final String SQL_UPDATE_COMPANY =
            "update companies set companyname = :companyname, phonenumber = :phonenumber where tin = :tin";
    private static final String SQL_DELETE_COMPANY =
            "delete from companies where tin = :tin";

    private final CompanyMapper companyMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public CompanyDaoImpl(
            CompanyMapper companyMapper,
            NamedParameterJdbcTemplate jdbcTemplate
    ) {
        this.companyMapper = companyMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Company> getAllCompanies() {
        return jdbcTemplate.query(
                SQL_GET_ALL_COMPANIES,
                companyMapper
        );
    }

    @Override
    public Optional<Company> getCompanyByTIN(String TIN) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tin", TIN);
        try {
            return Optional.ofNullable(
                    jdbcTemplate.queryForObject(
                            SQL_GET_COMPANY_BY_TIN,
                            params,
                            companyMapper
                    )
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void insertCompany(String companyName, String phoneNumber, String tin) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyname", companyName);
        params.addValue("phonenumber", phoneNumber);
        params.addValue("tin", tin);
        jdbcTemplate.update(SQL_INSERT_COMPANY, params);
    }

    @Override
    public void updateCompany(String companyName, String phoneNumber, String tin) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyname", companyName);
        params.addValue("phonenumber", phoneNumber);
        params.addValue("tin", tin);
        jdbcTemplate.update(SQL_UPDATE_COMPANY, params);
    }

    @Override
    public void deleteCompanyByTIN(String tin) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("tin", tin);
        jdbcTemplate.update(SQL_DELETE_COMPANY, params);
    }

}