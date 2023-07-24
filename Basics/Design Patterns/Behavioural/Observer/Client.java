import Observers.EmailAlert;
import Observers.FinancialAlertObserver;
import Observers.SmsAlert;
import Publishers.BankAccount;

public class Client {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        FinancialAlertObserver emailObs = new EmailAlert("sunil@gmail.com");
        FinancialAlertObserver smsObs = new SmsAlert("46365783678");

        account.addObserver(emailObs);
        account.addObserver(smsObs);

        account.updateBalance(2000);

        account.removeObserver(smsObs);

        account.updateBalance(1000);
    }
}
