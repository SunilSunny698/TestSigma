package Devices;

import java.util.ArrayList;
import java.util.List;

public class Router implements Device{
    String name;
    List<Device> subnet = new ArrayList<Device>();
    public Router(String name){
        this.name = name;
    }
    public void showDevices(){
        System.out.println("Network "+this.name+" devices");
        for (Device device : subnet) {
            device.showDevices();
        }
    }
    public void addDevice(Device d){
        subnet.add(d);
    }
}