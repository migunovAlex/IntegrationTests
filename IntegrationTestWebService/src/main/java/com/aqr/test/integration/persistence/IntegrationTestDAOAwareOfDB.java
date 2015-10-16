package com.aqr.test.integration.persistence;

import com.aqr.test.integration.entity.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by migunovo on 10/16/2015.
 */
@Transactional
public class IntegrationTestDAOAwareOfDB extends JdbcDaoSupport implements IntegrationTestDAO{

    @Autowired
    public IntegrationTestDAOAwareOfDB(DataSource dataSource) {
        super.setDataSource(dataSource);
    }

    public List<TestUser> getTestUserList() {
        return null;
    }

    public void saveUser(TestUser user) {

    }

    public void updateUser(TestUser user) {

    }

    public void deleteUser(TestUser user) {

    }
}
