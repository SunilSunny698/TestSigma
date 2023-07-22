import java.util.Scanner;

import Creator.AccesoriesFactory;
import Creator.AsusManufacturer;
import Creator.MsiManufacturer;
public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("What's your choice of accesory brand:");
        String user = in.next();
        AccesoriesFactory f;
        if(user.toLowerCase().equals("asus")){
            f=new AsusManufacturer();
            f.assembleAndExecute();
        }
        else if(user.toLowerCase().equals("msi")){
            f=new MsiManufacturer();
            f.assembleAndExecute();
        }
        else{
            System.out.println("Not avaiable");
        }
    }
}
