package Multi_Aspect;

public interface AuthorizationAspect {
    boolean authorize(String username, String permission);
}
