package Observers;

public class SmsAlert implements FinancialAlertObserver {
    private String phone;
    public SmsAlert(String phone){
        this.phone = phone;
    }
    public void update(String alertMsg){
        System.out.println("Sms alert to "+phone+" : "+alertMsg);
    }
}
