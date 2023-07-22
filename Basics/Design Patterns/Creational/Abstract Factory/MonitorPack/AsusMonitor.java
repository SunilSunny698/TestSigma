package MonitorPack;
public class AsusMonitor implements Monitor{
    public void switchOn(){
        System.out.println("Connected to Asus Monitor");
    }
    public void switchOff(){
        System.out.println("Asus Monitor disconnected");
    }    
}

