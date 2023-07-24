package Sensors;

import java.util.Random;
public class FarenheitSensor{

    public Temperature getTemperature(){
        float start = 28;
        float end = 40;
        float random = new Random().nextFloat();
        float result = start + (random * (end - start));
        return new Temperature("F",result);
    }
}
