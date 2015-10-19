package com.aqr.integration;

import com.aqr.test.integration.entity.TestUser;
import com.aqr.test.integration.persistence.IntegrationTestDAOAwareOfDB;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.sql.DataSource;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Oleksii_Migunov on 10/17/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppTestConfig.class, loader = AnnotationConfigContextLoader.class)

public class IntegrationSuiteTest {

    @Autowired
    public DataSource dataSource;

    private IntegrationTestDAOAwareOfDB testInstance;

    @Before
    public void setUp() {
        testInstance = new IntegrationTestDAOAwareOfDB(dataSource);
    }

    @Test
    public void test() {
        System.out.println("STARTING INTEGRATION");
        TestUser user = new TestUser(0, "John", "Dave", "john@gmail.com");
        testInstance.saveUser(user);
        List<TestUser> testUserList = testInstance.getTestUserList();
        assertEquals(1, testUserList.size());
    }


}
