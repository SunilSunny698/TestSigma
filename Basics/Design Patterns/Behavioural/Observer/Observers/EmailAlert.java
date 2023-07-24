package Observers;

public class EmailAlert implements FinancialAlertObserver{
    private String email;
    public EmailAlert(String email){
        this.email = email;
    }
    public void update(String alertMsg){
        System.out.println("Email alert to "+email+" : "+alertMsg);
    }
}
