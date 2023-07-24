package Paymode;

public class BankTransfer implements PaymentMethod{

    @Override
    public void pay(int amount) {
        System.out.println("Paid "+amount+" with Bank transfering");
        
    }
        
}
