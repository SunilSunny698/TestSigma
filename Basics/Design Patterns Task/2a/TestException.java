public class TestException extends Exception{
    String str;
    public TestException(String str){
        super(str);
        this.str = str;
    }

    @Override
    public String toString() {
        return "TestException: "+this.str;
    }
    
}
