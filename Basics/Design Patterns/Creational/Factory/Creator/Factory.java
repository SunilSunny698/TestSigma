package Creator;

import mypack.Gpu;


public abstract class Factory {
    
    public void execute(){
        Gpu cuda = selectGPU();
        cuda.enable();
        System.out.println("Working with the gpu");
        cuda.disable();
    }
    public abstract Gpu selectGPU();
    
}
