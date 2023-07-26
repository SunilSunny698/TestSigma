import java.util.ArrayList;
import java.util.List;

public class TestSuite extends TestComponent{
    public List<TestComponent> suite = new ArrayList<>();
    public String name;
    public int failCriteria;
    public TestSuite(String name, int failCriteria){
        this.name = name;
        this.failCriteria = failCriteria;
    }
    public void addTestcase(TestComponent t){
        suite.add(t);
    }
    public void removeTestcase(TestComponent t){
        suite.remove(t);
    }
    
    public void run(boolean b){
        int i=0;
        if(!b){
            for(i=0;i<failCriteria;i++){
                suite.get(i).run(false);
            }
        }
        else{
            for(int j=i;j<suite.size();j++){
                suite.get(i).run(true);
            }
        }
        this.status = b;
        this.check();
    }
    public void check(){
        try{
            if(!this.status){
                throw new TestException(this.name+" failed\n");
            }
        }
        catch(TestException e){
            System.out.println(e);
        }
    }
}
