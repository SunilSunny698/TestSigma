package Gmail;
public class BaseMail extends Mail{
    
    public BaseMail(String body,String subject,String to){
        this.body = body;
        this.subject = subject;
        this.to = to;
    }
    public void send(){
        System.out.println("Mail sent to "+this.to);
        System.out.println("Subject: "+this.subject);
        System.out.println("Body: "+this.body);
    }
}
