package com.example;

import com.example.dao.RoleDao;
import com.example.model.Role;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoleDaoTest {
    private RoleDao roleDao;

    @BeforeEach
    public void setUp() {
        roleDao = new RoleDao();
    }

    @AfterEach
    public void tearDown() throws SQLException {
        // Удаляем роль после теста
        List<Role> roles = roleDao.getAllRoles();
        for (Role role : roles) {
            if (role.getRoleName().equals("Test Role")) {
                roleDao.deleteRole(role.getId()); // Нужно реализовать deleteRole в RoleDao
            }
        }
    }

    @Test
    public void testGetAllRoles() throws SQLException {
        List<Role> roles = roleDao.getAllRoles();
        assertNotNull(roles);
        assertTrue(roles.size() >= 0);
    }

    @Test
    public void testAddRole() throws SQLException {
        Role role = new Role();
        role.setRoleName("Test Role");
        roleDao.addRole(role);

        List<Role> roles = roleDao.getAllRoles();
        assertTrue(roles.stream().anyMatch(r -> r.getRoleName().equals("Test Role")));
    }
}
