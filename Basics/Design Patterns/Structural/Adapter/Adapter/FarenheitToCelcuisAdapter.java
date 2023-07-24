package Adapter;

import Sensors.CelciusSensor;
import Sensors.FarenheitSensor;
import Sensors.Temperature;

public class FarenheitToCelcuisAdapter extends CelciusSensor{
    FarenheitSensor fs;
    public FarenheitToCelcuisAdapter(FarenheitSensor fs){
        this.fs = fs;
    }
    @Override
    public Temperature getTemperature(){
        Temperature t = fs.getTemperature();
        float result =(float)((t.value - 32) * 5.0 / 9.0);
        return new Temperature("C",result);
    }    
}
