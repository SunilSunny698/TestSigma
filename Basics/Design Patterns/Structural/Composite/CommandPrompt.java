import Devices.Computer;
import Devices.Device;
import Devices.Router;

public class CommandPrompt {
    public Router configure(){
        Device end;
        Router root = new Router("root");

        Router subnet1 = new Router("subnet1");
        for(int i=0;i<3;i++){
            end = new Computer("PC"+(i+1));
            subnet1.addDevice(end);
        }

        Router subnet2 = new Router("subnet2");
        for(int i=0;i<4;i++){
            end = new Computer("PC"+(i+1));
            subnet2.addDevice(end);
        }

        root.addDevice(subnet1);
        root.addDevice(subnet2);
        return root;
    }
}
