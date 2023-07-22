package Creator;

import mypack.Asusgpu;
import mypack.Gpu;

public class AsusManufacturer extends Factory {
    @Override
    public Gpu selectGPU(){
        return new Asusgpu();
    }
}
