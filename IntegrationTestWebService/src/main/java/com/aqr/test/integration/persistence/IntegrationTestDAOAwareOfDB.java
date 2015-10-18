package com.aqr.test.integration.persistence;

import com.aqr.test.integration.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by migunovo on 10/16/2015.
 */
@Transactional
public class IntegrationTestDAOAwareOfDB extends JdbcDaoSupport implements IntegrationTestDAO {

    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String INSERT_NEW_USER = "INSERT INTO `users`\n" +
            " (`user_name`, `user_last_name`, `user_email`)\n" +
            " VALUES (?, ?, ?)";
    private static final String UPDATE_USER = "UPDATE `users` SET `user_name` = ?, `user_last_name` = ?,\n" +
            "`user_email` = ? WHERE `id` = ?";
    private static final String DELETE_USER = "DELETE FROM `users` WHERE id=?";


    @Autowired
    public IntegrationTestDAOAwareOfDB(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public List<TestUser> getTestUserList() {
        List<TestUser> userList = Collections.emptyList();

        try {
            userList = getJdbcTemplate().query(SELECT_ALL_USERS, new UserExtractor());
        } catch (Exception e) {
            e.getStackTrace();
        }

        return userList;
    }

    public void saveUser(TestUser user) {
        try {
            getJdbcTemplate().update(INSERT_NEW_USER, new Object[]{user.getUserName(),
                    user.getUserLastName(), user.getUserEmail()});
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void updateUser(TestUser user) {
        try {
            getJdbcTemplate().update(UPDATE_USER, new Object[]{user.getUserName(),
                    user.getUserLastName(), user.getUserEmail(), user.getId()});
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void deleteUser(TestUser user) {
        try {
            getJdbcTemplate().update(DELETE_USER, new Object[]{user.getId()});
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    private class UserExtractor implements ResultSetExtractor<List<TestUser>> {
        public List<TestUser> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
            List<TestUser> resultList = new ArrayList<TestUser>();

            while (resultSet.next()) {
                resultList.add(new TestUser(resultSet.getInt("id"), resultSet.getString("user_name"),
                        resultSet.getString("user_last_name"), resultSet.getString("user_email")));
            }

            return resultList;
        }
    }
}
