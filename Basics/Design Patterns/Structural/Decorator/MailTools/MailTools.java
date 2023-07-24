package MailTools;


import Gmail.Mail;

public class MailTools extends Mail{

    protected Mail bmail;
    public MailTools(Mail bmail){
        this.bmail = bmail;
    }
    @Override
    public void send() {
        bmail.send();
    }
    
}
