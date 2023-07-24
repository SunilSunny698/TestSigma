package Ciphers;

public class Des implements Cipher{

    public final String name = "AES";
    @Override
    public void PlainTexttoBlocks() {
        System.out.println("Plain text is divide into 64 bit of blocks");
        
    }

    @Override
    public void ProcessEachBlock() {
        System.out.println("Each 64 bit block is encrypted using DES");
        
    }

    @Override
    public void GenerateCipher() {
        System.out.println("Cipher text is generated for the plain text");
        
    }

    @Override
    public String getName() {
        return "DES";
    }
}
