package Creator;

import mypack.Gpu;
import mypack.Msigpu;

public class MsiManufacturer extends Factory{
    @Override
    public Gpu selectGPU(){
        return new Msigpu();
    }
}
