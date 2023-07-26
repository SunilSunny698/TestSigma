import Pins.*;
public class Socket {
    public static boolean fit(Pin p){
        if(p.getPinType().toLowerCase().equals("i") || p.getPinType().toLowerCase().equals("au") || p.getPinType().toLowerCase().equals("af")){
            return true;
        }
        return false;
    }
    public static void plugIn(Pin p){
        if(Socket.fit(p)){
            System.out.println("Charger plugged in..\nCharging..\n");
        }
        else{
            System.out.println("Incompatible socket and plug\n");
        }
    }

}
