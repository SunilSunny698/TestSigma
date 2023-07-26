public class ExceptionDemo {
    public static void main(String[] args) {
        try{
            throw new ExceptionLevel1("User defined exception");
        } catch(ExceptionLevel1 e){
            System.out.println(e.getMessage());
            e.throwException("Caused by level 1");
        }
    }
}
