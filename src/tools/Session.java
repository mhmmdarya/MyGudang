package tools;

public class Session {
    
    private static int id;
    private static String name;
//    private static String password;
    private static String role;

    public static void setRole(String role) {
        Session.role = role;
    }
    
    public static String getRole(){
        return Session.role;
    }
    
    public static int getId(){
        return Session.id;
    }
    
    public static void setAll(String data[]){
        Session.id = Integer.parseInt(data[0]);
        Session.name = data[1];
        Session.role = data[2];
    }
    
    public static void setName(String username) {
        Session.role = name;
    }
    
    public static String getName(){
        return Session.name;
    }
    
    public static void resetAll(){
        Session.name = "";
        Session.role = "";
    }
    
//    public static void setPassword(String password) {
//        Session.role = password;
//    }
//    
//    public static String getPassword(){
//        return Session.password;
//    }
}
