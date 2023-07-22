package MonitorPack;
public class MsiMonitor implements Monitor{
    public void switchOn(){
        System.out.println("Connected to MSI Monitor");
    }
    public void switchOff(){
        System.out.println("MSI Monitor disconnected");
    }    
}
