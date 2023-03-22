package Multi_Aspect;

import org.junit.Test;

import static org.junit.Assert.*;

public class MultiAspectInheritanceTest {

    @Test
    public void testRegularUserAuthentication(){
        RegularUser regularUser = new RegularUser("user1", "password11");
        boolean isAuthenticated = regularUser.authenticate(regularUser.getUserName(), regularUser.getPassword());
        assertTrue(isAuthenticated);
        isAuthenticated = regularUser.authenticate(regularUser.getUserName(), "passwword11");
        assertFalse(isAuthenticated);
    }

    @Test
    public void testAdminUserAuthentication(){
        AdminUser adminUser = new AdminUser("admin1", "password22");
        boolean isAuthenticated = adminUser.authenticate(adminUser.getUserName(), adminUser.getPassword());
        assertTrue(isAuthenticated);
        isAuthenticated = adminUser.authenticate(adminUser.getUserName(), "passswoeo");
        assertFalse(isAuthenticated);
    }

    @Test
    public void testAdminUserAuthorization(){
        AdminUser adminUser = new AdminUser("admin1", "password22");
        boolean isAuthorized = adminUser.authorize("admin1", "permission123");
        assertTrue(isAuthorized);
    }

    @Test
    public void testAdminUserLog(){
        AdminUser adminUser = new AdminUser("admin1", "password22");
        adminUser.log("Hello World!!");
    }
}