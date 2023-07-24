import Gateway.PaymentGateway;
import Gateway.Paytm;
import Gateway.Phonepay;
import Paymode.BankTransfer;
import Paymode.PaymentMethod;
import Paymode.UpiTransfer;

public class PaymentPage {
    public void ProceedPayment(String mode,String gateway,int amount){
        PaymentMethod m = new UpiTransfer();
        if(mode.toLowerCase().equals("bank")){
            m = new BankTransfer();
        }
        PaymentGateway g = new Paytm(m);
        if(gateway.toLowerCase().equals("phonepay")){
            g = new Phonepay(m);
        }

        g.processTransaction(amount);
    }
}
