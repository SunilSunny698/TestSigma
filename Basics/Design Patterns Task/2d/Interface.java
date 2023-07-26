import Adapters.AmericanToIndianAdapter;
import Adapters.FrenchToIndianAdapter;
import Pins.AmericanPin;
import Pins.FrenchPin;

public class Interface {
    public static void main(String[] args) {
        System.out.println("American");
        AmericanPin AmP = new AmericanPin();
        Socket.plugIn(AmP);
        System.out.println("American with adapter");
        AmericanToIndianAdapter AI = new AmericanToIndianAdapter(AmP);
        Socket.plugIn(AI);

        System.out.println("French");
        FrenchPin FrP = new FrenchPin();
        Socket.plugIn(FrP);
        System.out.println("French with adapter");
        FrenchToIndianAdapter FI = new FrenchToIndianAdapter(FrP);
        Socket.plugIn(FI);
    }
}
