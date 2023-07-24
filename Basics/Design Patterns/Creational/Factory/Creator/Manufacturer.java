package Creator;

import mypack.Gpu;


public abstract class Factory {
    
    public void execute(){
        Gpu cuda = selectGPU();
        cuda.enable();
        System.out.println("Working with the gpu");
        cuda.disable();
    }
    public static Factory configure(String user){
        Factory f = new AsusManufacturer();
        if(user.toLowerCase().equals("msi")){
            f=new MsiManufacturer();
            f.execute();
        }
        return f;
    }
    public abstract Gpu selectGPU();
    
}
