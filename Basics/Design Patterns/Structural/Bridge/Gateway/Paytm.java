package Gateway;

import Paymode.PaymentMethod;

public class Paytm implements PaymentGateway{
    private PaymentMethod mode;
    public Paytm(PaymentMethod mode){
        this.mode = mode;
    }

    @Override
    public void processTransaction(int amount) {
        System.out.println("Initiating Paytm payment Gateway for the transaction");
        mode.pay(amount);
    }
}
