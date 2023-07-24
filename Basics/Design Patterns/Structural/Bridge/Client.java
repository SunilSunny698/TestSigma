public class Client {
    public static void main(String[] args) {
        PaymentPage page = new PaymentPage();
        System.out.println("\n\nRedirecting to payment page");
        page.ProceedPayment("bank", "paytm", 6000);
        System.out.println("Your transaction is completed\n");
    }
}
