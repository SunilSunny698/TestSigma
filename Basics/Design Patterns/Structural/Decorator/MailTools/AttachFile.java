package MailTools;

import Gmail.Mail;

public class AttachFile extends MailTools{
    
    public AttachFile(Mail bmail, String filename){
        super(bmail);
        this.attach(filename);
    }

    public void attach(String filename){
        bmail.file = filename;
    }
    @Override
    public void send(){
        bmail.send();
        System.out.println("Attached file is: "+bmail.file);
    }
}

