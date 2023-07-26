import Elements.Bank;
import Elements.Client;
import Elements.Company;
import Visitors.InsuranceNotifierVisitor;
import Visitors.Visitor;

public class Insurance {
    public static void main(String[] args) {
        Client[] clients = {new Bank("HDFC", "hdfc@gmail"),new Company("Test sigma", "ts@gmail.com")};
        Visitor v = new InsuranceNotifierVisitor();

        for (Client client : clients) {
            client.accept(v);
        }
    }
}
