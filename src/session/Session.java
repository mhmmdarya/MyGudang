package session;

public class Session {

    private static String role;

    public static void setRole(String role) {
        Session.role = role;
    }
    
    public static String getRole(){
        return Session.role;
    }
}
