import Adapter.FarenheitToCelcuisAdapter;
import Sensors.CelciusSensor;
import Sensors.FarenheitSensor;
import Sensors.Temperature;

public class Client {
    public static void main(String[] args) {
        FarenheitSensor fs = new FarenheitSensor();
        CelciusSensor cs = new FarenheitToCelcuisAdapter(fs);
        Temperature t = cs.getTemperature();
        
        System.out.println(t);
    }
}
