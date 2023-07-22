public class Database {

    private static volatile Database db;
    public String data;
    private Database(String data){
        this.data = data;
    }

    public static Database getDatabase(String data){
        if(db == null){
            synchronized(Database.class){
                if(db == null){
                    db = new Database(data);
                }
            }
        }
        return db;
    }
}