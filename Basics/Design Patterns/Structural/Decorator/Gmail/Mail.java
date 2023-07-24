package Gmail;

public abstract class Mail {
    public String body;
    public String subject;
    public String to;
    public String file;
    public String image;
    public abstract void send();
}
