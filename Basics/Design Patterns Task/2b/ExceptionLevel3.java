public class ExceptionLevel3 extends Exception{
    public ExceptionLevel3(String str){
        super(str+": At level 3");
    }
    public void throwException(String str){
        try{
            throw new ExceptionLevel4("Caused by level 3");
        } catch(ExceptionLevel4 e){
            System.out.println(e.getMessage());
        }
    }
}

