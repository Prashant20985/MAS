package Multi_Aspect;

public class AdminUser extends User implements AuthenticationAspect, AuthorizationAspect, LoggingAspect{
    public AdminUser(String userName, String password) {
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

    @Override
    public boolean authorize(String username, String permission) {
        if (username.equals(this.userName) && permission.equals("permission123")) {
            System.out.println("User " + this.userName + " authorized for permission " + permission);
            return true;
        }
        System.out.println("Authorization failed.");
        return false;
    }

    @Override
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
