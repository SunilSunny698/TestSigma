public class TestCase extends TestComponent{
    public String name;
    public boolean status;
    public TestCase(String name){
        this.name = name;
    }
    public void run(boolean b){
        this.status = b;
        this.check();
    }
    public void check(){
        try{
            if(!this.status){
                throw new TestException(name+" Failed");
            }
        }
        catch(TestException e){
            System.out.println(e);
        }
    }
}
