package Multi_Aspect;

public abstract class User {
    protected String userName;
    protected String password;


    public User(String userName, String password) {
        setUserName(userName);
        setPassword(password);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if(userName == null || userName.isBlank()){
            throw new IllegalArgumentException("User Name must not be null or blank");
        }
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null || password.isBlank()){
            throw new IllegalArgumentException("Password must not be null or blank");
        }
        this.password = password;
    }
}
