package Vendors;

public class Phonepay implements Upi{

    @Override
    public void credit(double money) {
        System.out.println("Crediting "+money+" using phonepay");
        
    }

    @Override
    public void debit(double money) {
        // TODO Auto-generated method stub
        System.out.println("Debiting "+money+" using phonepay");
        
    }
        
}
