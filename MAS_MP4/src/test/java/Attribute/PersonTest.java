package Attribute;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {

    private Person person;

    @Before
    public void setUp(){
        person = new Person("testUser", "User", "User last", 21);
    }

    @Test
    public void testSetAge(){
        person.setAge(25);
        assertEquals(25, person.getAge());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidAge(){
        person.setAge(16);
    }

    @Test
    public void testSetUserName(){
        person.setUserName("TestUser");
        assertEquals("TestUser", person.getUserName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidUserName(){
        person.setUserName("gfuyesrifhgirsgh;l");
    }
}