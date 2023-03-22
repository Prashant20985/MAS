package Multi_Aspect;

public class RegularUser extends User implements AuthenticationAspect {

    public RegularUser(String userName, String password) {
        super(userName, password);
    }

    @Override
    public boolean authenticate(String username, String password) {
        if(username.equals(this.userName) && password.equals(this.password)){
            System.out.println("User " + this.userName + " authenticated");
            return true;
        }
        System.out.println("Authentication Failed");
        return false;
    }
}
