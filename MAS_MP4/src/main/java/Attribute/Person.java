package Attribute;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Person {

    private String userName;
    private String firstName;
    private String lastName;
    private int age;

    private int MAX_USERNAME_LENGTH = 10;

    public Person(String userName, String firstName, String lastName, int age) {
        setFirstName(firstName);
        setLastName(lastName);
        setUserName(userName);
        setAge(age);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName == null || userName.isEmpty()){
            throw new IllegalArgumentException("User name must not be blank or null");
        }
        if(userName.length() > MAX_USERNAME_LENGTH){
            throw new IllegalArgumentException("User name should not exceed the max limit");
        }
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("firstName must not be blank or null");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("lastName must not be blank or null");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        int minAgeLimit = 18;

        if(age < minAgeLimit){
            throw new IllegalArgumentException("Age should be grater than 18");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
