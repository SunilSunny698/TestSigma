package Creator;

import GPUPack.Gpu;
import MonitorPack.Monitor;
import MousePack.Mouse;

public abstract class AccesoriesFactory {
    public void assembleAndExecute(){
        Monitor desktop = connectMonitor();
        desktop.switchOn();
        Mouse mouse = connectMouse();
        mouse.connect();
        execute();
        mouse.disconnect();
        desktop.switchOff();
    }
    public void execute(){
        Gpu cuda = selectGpu();
        cuda.enable();
        System.out.println("Work in progress with cuda");
        System.out.println("......");
        System.out.println("Success.");
        cuda.disable();
    }
    public abstract Monitor connectMonitor();
    public abstract Gpu selectGpu();
    public abstract Mouse connectMouse();
}
