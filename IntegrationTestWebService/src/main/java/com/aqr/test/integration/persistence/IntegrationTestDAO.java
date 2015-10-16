package com.aqr.test.integration.persistence;

import com.aqr.test.integration.entity.TestUser;

import java.util.List;

/**
 * Created by migunovo on 10/16/2015.
 */
public interface IntegrationTestDAO {

    List<TestUser> getTestUserList();

    void saveUser(TestUser user);

    void updateUser(TestUser user);

    void deleteUser(TestUser user);

}
