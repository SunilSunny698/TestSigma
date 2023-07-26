public class TestEnvironment {
    public static void main(String[] args) {
        TestPlan tp = new TestPlan(2);
        tp.designTestPlan();
        tp.executeTestPlan(false);
    }
}
