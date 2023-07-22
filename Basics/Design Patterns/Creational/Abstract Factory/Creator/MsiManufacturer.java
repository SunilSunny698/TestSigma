package Creator;


import GPUPack.Gpu;
import GPUPack.Msigpu;
import MonitorPack.Monitor;
import MonitorPack.MsiMonitor;
import MousePack.Mouse;
import MousePack.MsiMouse;

public class MsiManufacturer extends AccesoriesFactory{
    public Gpu selectGpu(){
        return new Msigpu();
    }
    public Monitor connectMonitor(){
        return new MsiMonitor();
    }
    public Mouse connectMouse(){
        return new MsiMouse();
    }
}
