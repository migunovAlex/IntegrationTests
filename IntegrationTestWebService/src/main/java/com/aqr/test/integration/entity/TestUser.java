package com.aqr.test.integration.entity;

/**
 * Created by migunovo on 10/16/2015.
 */
public class TestUser {

    private final long id;
    private final String userName;
    private final String userLastName;
    private final String userEmail;

    public TestUser(long id, String userName, String userLastName, String userEmail) {
        this.id = id;
        this.userName = userName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestUser testUser = (TestUser) o;

        if (id != testUser.id) return false;
        if (userName != null ? !userName.equals(testUser.userName) : testUser.userName != null) return false;
        if (userLastName != null ? !userLastName.equals(testUser.userLastName) : testUser.userLastName != null)
            return false;
        return !(userEmail != null ? !userEmail.equals(testUser.userEmail) : testUser.userEmail != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userLastName != null ? userLastName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
