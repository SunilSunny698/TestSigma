import Devices.Router;

public class Client {
    public static void main(String[] args) {
        CommandPrompt cmd = new CommandPrompt();
        Router root = cmd.configure();

        root.showDevices();
    }
}
