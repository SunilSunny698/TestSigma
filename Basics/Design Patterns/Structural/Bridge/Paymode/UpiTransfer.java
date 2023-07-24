package Paymode;

public class UpiTransfer implements PaymentMethod{

    @Override
    public void pay(int amount) {
        System.out.println("Paid "+amount+" with upi transfering");
    }
}
