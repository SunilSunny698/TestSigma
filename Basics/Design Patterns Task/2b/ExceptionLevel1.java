public class ExceptionLevel1 extends Exception{
    public ExceptionLevel1(String str){
        super(str+": At level 1");
    }
    public void throwException(String str){
        try{
            throw new ExceptionLevel2(str);
        } catch(ExceptionLevel2 e){
            System.out.println(e.getMessage());
            e.throwException("Caused by level 2");
        }
    }
    
}