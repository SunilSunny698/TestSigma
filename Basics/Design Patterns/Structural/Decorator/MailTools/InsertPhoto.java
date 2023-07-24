package MailTools;

import Gmail.Mail;

public class InsertPhoto extends MailTools{

    public InsertPhoto(Mail bmail,String imgname){
        super(bmail);
        this.insert(imgname);
    }
    public void insert(String imgname){
        bmail.image = imgname;
    }
    @Override
    public void send() {
        super.send();
        System.out.println("Image name: "+bmail.image);
    }
       
}
