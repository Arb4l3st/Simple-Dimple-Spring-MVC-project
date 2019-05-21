package ru.arbalest.dao;

import ru.arbalest.dao.mapper.UserMapper;
import ru.arbalest.models.OneUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Контроллер для получения списка юзеров
 */
@Repository
public class UserDaoImpl implements UserDAO {

        private static final String SQL_GET_USER_BY_ID =
            "select fio, dater, email, companyname, id from users where id = :id";
        private static final String SQL_GET_ALL_USERS =
            "select * from users";
        private static final String SQL_GET_USERS_BY_COMPANY    =
            "select * from users where users.companyname = :companyname";
        private static final String SQL_INSERT_USER =
            "insert into users (fio, dater, email, companyname, id) values (:fio, :dater, :email,:companyname,:id)";
        private static final String SQL_UPDATE_USER =
            "update users set fio = :fio, dater = :dater, email = :email, companyname = :companyname where id = :id";
        private static final String SQL_DELETE_USER =
            "delete from users where id = :id";

        private final UserMapper userMapper;
        private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(
                UserMapper userMapper,
                NamedParameterJdbcTemplate jdbcTemplate
        ) {
            this.userMapper = userMapper;
            this.jdbcTemplate = jdbcTemplate;
        }

        @Override
        public Optional<OneUser> getUserById(int id) {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue("id", id);
            try {
                return Optional.ofNullable(
                        jdbcTemplate.queryForObject(
                                SQL_GET_USER_BY_ID,
                                params,
                                userMapper
                        )
                );
            } catch (EmptyResultDataAccessException e) {
                return Optional.empty();
            }
        }

    @Override
    public List<OneUser> getAllUsers() {
        return jdbcTemplate.query(
                SQL_GET_ALL_USERS,
                userMapper
        );
    }

    @Override
    public List<OneUser> getUsersByCompany(String companyName) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("companyname", companyName);
        return jdbcTemplate.query(
                SQL_GET_USERS_BY_COMPANY,
                params,
                userMapper
        );
    }

    @Override
    public void insertUser(String fio, String dater, String email, String companyName, int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("fio", fio);
        params.addValue("dater", dater);
        params.addValue("email", email);
        params.addValue("companyname", companyName);
        params.addValue("id", id);
        jdbcTemplate.update(SQL_INSERT_USER, params);
    }

    @Override
    public void updateUser(String fio, String dater, String email, String companyName, int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("fio", fio);
        params.addValue("dater", dater);
        params.addValue("email", email);
        params.addValue("companyname", companyName);
        params.addValue("id", id);
        jdbcTemplate.update(SQL_UPDATE_USER, params);
    }

    @Override
    public void deleteUserById(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbcTemplate.update(SQL_DELETE_USER, params);
    }

}

