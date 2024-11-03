package com.example;

import com.example.dao.UserDao;
import com.example.model.User;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    private UserDao userDao;

    @BeforeEach
    public void setUp() {
        userDao = new UserDao();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        List<User> users = userDao.getAllUsers();
        for (User user : users) {
            if (user.getName().equals("Test User")) {
                userDao.deleteUser(user.getId());
            }
        }
    }

    @Test
    public void testGetAllUsers() throws SQLException {
        List<User> users = userDao.getAllUsers();
        assertNotNull(users);
        assertTrue(users.size() >= 0);
    }

    @Test
    public void testAddUser() throws SQLException {
        User user = new User();
        user.setName("Test User");
        userDao.addUser(user);

        List<User> users = userDao.getAllUsers();
        assertTrue(users.stream().anyMatch(u -> u.getName().equals("Test User")));
    }
}
