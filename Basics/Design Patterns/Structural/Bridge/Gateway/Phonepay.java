package Gateway;

import Paymode.PaymentMethod;

public class Phonepay implements PaymentGateway{
    private PaymentMethod mode;

    public Phonepay(PaymentMethod mode) {
        this.mode = mode;
    }
    @Override
    public void processTransaction(int amount) {
        System.out.println("Intiating Phonepay payment gateway for the transaction");
        mode.pay(amount);
    }
        
}
