import Vendors.Upi;

public class Gateway {
    private Upi upi;

    public void setUpi(Upi upi) {
        this.upi = upi;
    }

    public void processPayment(double money){
        System.out.println("Payment Initiated");
        upi.debit(money);
        upi.credit(money);
        System.out.println("Payment completed successfully");
    }
}
