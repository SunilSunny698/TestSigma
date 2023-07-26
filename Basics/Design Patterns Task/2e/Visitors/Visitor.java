package Visitors;
import Elements.*;
public interface Visitor {
    public void visit(Bank bank);
    public void visit(Company company);
}
