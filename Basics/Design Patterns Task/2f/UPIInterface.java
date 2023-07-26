import Vendors.Phonepay;

public class UPIInterface {
    public static void main(String[] args) {
        Gateway g = new Gateway();
        g.setUpi(new Phonepay());
        g.processPayment(4000);
    }
}
