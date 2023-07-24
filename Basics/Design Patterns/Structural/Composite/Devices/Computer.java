package Devices;

public class Computer implements Device{
    String name;
    public Computer(String name){
        this.name = name;
    }
    public void showDevices(){
        System.out.println(this.name);
    }
    
}
