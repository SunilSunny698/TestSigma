package MousePack;
public class MsiMouse implements Mouse{
    public void connect(){
        System.out.println("MSI mouse is connected");
    }
    public void disconnect(){
        System.out.println("MSI mouse is disconnected");
    }    
}