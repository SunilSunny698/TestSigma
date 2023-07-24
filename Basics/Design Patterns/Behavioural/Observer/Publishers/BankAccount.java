package Publishers;

import java.util.ArrayList;
import java.util.List;

import Observers.FinancialAlertObserver;

public class BankAccount {
    List<FinancialAlertObserver> users = new ArrayList<>();
    private float balance;
    public void addObserver(FinancialAlertObserver fas){
        users.add(fas);
    }
    public void removeObserver(FinancialAlertObserver fas){
        users.remove(fas);
    }

    public void updateBalance(float money){
        this.balance = money;
        notifyObservers("Account balance changed to :"+balance);
    }

    public void notifyObservers(String msg){
        for (FinancialAlertObserver financialAlertObserver : users) {
            financialAlertObserver.update(msg);
        }
    }
}
