package Vendors;

public class Paytm implements Upi{

    @Override
    public void credit(double money) {
        System.out.println("Crediting "+money+" using paytm");
        
    }

    @Override
    public void debit(double money) {
        // TODO Auto-generated method stub
        System.out.println("Debiting "+money+" using paytm");
        
    }
        
}