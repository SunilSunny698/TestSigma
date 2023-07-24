import java.util.Scanner;

import Creator.Factory;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("GPU, you wanna work with.. :");
        String user = in.next();
        Factory f = Factory.configure(user);
        f.execute();
        
    }
}

