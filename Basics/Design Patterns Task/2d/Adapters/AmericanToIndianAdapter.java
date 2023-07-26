package Adapters;

import Pins.AmericanPin;
import Pins.IndianPin;

public class AmericanToIndianAdapter extends IndianPin{
    private AmericanPin pin;

    public AmericanToIndianAdapter(AmericanPin pin){
        this.pin = pin;
    }
    @Override
    public String getPinType(){
        pin.pinType = "AU";
        return pin.pinType;
    }
}
