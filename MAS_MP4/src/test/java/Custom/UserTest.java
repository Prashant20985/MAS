package Custom;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void test(){
        User user = new User("Test", "TestLastName", "testUser", Role.APP_USER.toString());
        assertEquals("APP_USER", user.getUserRole());
        user.changeRole(Role.ADMIN.toString());
        assertEquals("ADMIN", user.getUserRole());
        assertThrows(IllegalArgumentException.class, () -> user.setUserRole("klfosergj"));
        assertThrows(IllegalArgumentException.class, () -> user.changeRole("ffdgdhgf"));
    }
}