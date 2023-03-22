package Custom;

import java.util.Arrays;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String userRole;

    public User(String firstName, String lastName, String userName, String userRole) {
        setFirstName(firstName);
        setUserName(userName);
        setLastName(lastName);
        setUserRole(userRole);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null || firstName.isEmpty()){
            throw new IllegalArgumentException("firstName must not be null or Empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new IllegalArgumentException("lastName must not be null or Empty");
        }
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName == null || userName.isEmpty()){
            throw new IllegalArgumentException("userName must not be null or Empty");
        }
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        if(!Arrays.stream(Role.values()).anyMatch(x -> x.name().equals(userRole))){
            throw new IllegalArgumentException("Invalid role input");
        }
        this.userRole = userRole;
    }

    public void changeRole(String userRole){
        if(!Arrays.stream(Role.values()).anyMatch(x -> x.name().equals(userRole))){
            throw new IllegalArgumentException("Invalid role input");
        }
        if(this.userRole.equals(userRole)){
            throw new IllegalArgumentException("User already has provided role");
        }

        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}
