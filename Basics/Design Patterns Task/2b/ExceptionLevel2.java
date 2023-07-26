public class ExceptionLevel2 extends Exception{
    public ExceptionLevel2(String str){
        super(str+": At level 2");
    }
    public void throwException(String str){
        try{
            throw new ExceptionLevel3(str);
        } catch(ExceptionLevel3 e){
            System.out.println(e.getMessage());
            e.throwException("Caused by level 3");
        }
    }
}
