import java.util.Scanner;

import Creator.AsusManufacturer;
import Creator.Factory;
import Creator.MsiManufacturer;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("GPU, you wanna work with.. :");
        String user = in.next();
        Factory f;
        if(user.toLowerCase().equals("asus")){
            f=new AsusManufacturer();
            f.execute();
        }
        else if(user.toLowerCase().equals("msi")){
            f=new MsiManufacturer();
            f.execute();
        }
        else{
            System.out.println("Not avaiable");
        }
    }
}
