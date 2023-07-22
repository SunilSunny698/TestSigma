public class User {
    public static void main(String[] args) {
        Database dbase = Database.getDatabase("User");
        Database anotherdb = Database.getDatabase("Another");
        System.out.println(dbase.data);
        System.out.println(anotherdb.data);
    }
    
}
