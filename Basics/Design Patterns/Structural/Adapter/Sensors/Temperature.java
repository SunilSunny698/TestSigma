package Sensors;

public class Temperature {
    public String unit;
    public float value;
    public Temperature(String unit, float value){
        this.unit = unit;
        this.value = value;
    }
    @Override
    public String toString() {
        return value+"'"+unit;
    }

}
