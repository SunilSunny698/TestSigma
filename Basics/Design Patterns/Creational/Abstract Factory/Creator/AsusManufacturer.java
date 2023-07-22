package Creator;

import GPUPack.Asusgpu;
import GPUPack.Gpu;
import MonitorPack.AsusMonitor;
import MonitorPack.Monitor;
import MousePack.AsusMouse;
import MousePack.Mouse;

public class AsusManufacturer extends AccesoriesFactory{
    public Gpu selectGpu(){
        return new Asusgpu();
    }
    public Monitor connectMonitor(){
        return new AsusMonitor();
    }
    public Mouse connectMouse(){
        return new AsusMouse();
    }
}
