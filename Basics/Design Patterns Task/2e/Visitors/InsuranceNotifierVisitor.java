package Visitors;

import Elements.Bank;
import Elements.Company;

public class InsuranceNotifierVisitor implements Visitor{

    @Override
    public void visit(Bank bank) {
        System.out.println("Sending insurance mail to bank with the mail "+bank.email);
    }

    @Override
    public void visit(Company company) {
        System.out.println("Sending insurance mail to company with the mail "+company.email);
    }

}