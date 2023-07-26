package Adapters;

import Pins.FrenchPin;
import Pins.IndianPin;

public class FrenchToIndianAdapter extends IndianPin{
    private FrenchPin pin;
    public FrenchToIndianAdapter(FrenchPin pin){
        this.pin = pin;
    }
    @Override
    public String getPinType() {
        pin.pinType = "AF";
        return pin.pinType;
        
    }

    
}
