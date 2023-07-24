import Gmail.BaseMail;
import Gmail.Mail;
import MailTools.AttachFile;
import MailTools.InsertPhoto;

public class ComposeMail {
    public void compose(String feature){
        Mail m = new BaseMail("This is the body","Testing Decorator","sunilmail");
        if(feature == "file"){
            
            Mail mailWithFile = new AttachFile(m,"sunil.pdf");
            System.out.println("\nMail with file\n");
            mailWithFile.send();
        }
         
        else if (feature == "image"){
            Mail mailWithImage = new InsertPhoto(m,"sunil.png");
            System.out.println("\n\nMail with image\n");
            mailWithImage.send();
        }
        
    }
    
}
