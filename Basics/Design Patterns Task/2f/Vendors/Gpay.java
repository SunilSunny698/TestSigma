package Vendors;

public class Gpay implements Upi{

    @Override
    public void credit(double money) {
        System.out.println("Crediting "+money+" using gpay");
        
    }

    @Override
    public void debit(double money) {
        // TODO Auto-generated method stub
        System.out.println("Debiting "+money+" using gpay");
        
    }
        
}