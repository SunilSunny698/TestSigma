import java.util.ArrayList;
import java.util.List;

public class TestPlan {
    public List<TestSuite> Testplan = new ArrayList<>();
    public int failCriteria;
    public boolean status;
    public TestPlan(int failCriteria){
        this.failCriteria = failCriteria;
    }
    public void designTestPlan(){
        
        TestComponent t;
        TestSuite s1 = new TestSuite("Testsuite 1",3);
        
        for(int i=0;i<5;i++){
            t = new TestCase("Testsuite-1 tcase"+(i+1));
            s1.addTestcase(t);
        }

        TestSuite s2 = new TestSuite("Testsuite 2",2);
        for(int i=0;i<5;i++){
            t = new TestCase("Testsuite-2 tcase"+(i+1));
            s2.addTestcase(t);
        }

        TestSuite s3 = new TestSuite("Testsuite 3",1);
        for(int i=0;i<5;i++){
            t = new TestCase("Testsuite-3 tcase"+(i+1));
            s3.addTestcase(t);
        }
        Testplan.add(s1);
        Testplan.add(s2);
        Testplan.add(s3);
    }
    public void executeTestPlan(boolean b){
        int i=0;
        if(!b){
            for(i=0;i<failCriteria;i++){
                Testplan.get(i).run(false);
            }
        }
        else{
            for(int j=i;j<Testplan.size();j++){
                Testplan.get(i).run(true);
            }
        }
        this.status = b;
        this.check();
    }
    public void check(){
        try{
            if(!this.status){
                throw new TestException("Test Plan failed");
            }
            else{
                System.out.println("Test plan passed");
            }
        }
        catch(TestException e){
            System.out.println(e);
        }
    }
}
