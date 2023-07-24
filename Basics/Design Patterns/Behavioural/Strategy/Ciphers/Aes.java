package Ciphers;

public class Aes implements Cipher{
    public final String name = "AES";

    
    @Override
    public void PlainTexttoBlocks() {
        System.out.println("Plain text is divide into 128bit of blocks");
        
    }

    @Override
    public void ProcessEachBlock() {
        System.out.println("Each 128 bit block is encrypted using AES");
        
    }

    @Override
    public void GenerateCipher() {
        System.out.println("Cipher text is generated for the plain text");
        
        
    }

    @Override
    public String getName() {
        return "AES";
    }
        
}
