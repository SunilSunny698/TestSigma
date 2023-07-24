package Encryption;

import Ciphers.Cipher;

public class Encrypter{
    private Cipher enCipher;

    public void encrypt(String plainText){
        System.out.println("Initiating "+enCipher.getName()+" algorithm for encryption");
        enCipher.PlainTexttoBlocks();
        enCipher.ProcessEachBlock();
        enCipher.GenerateCipher();
        System.out.println("Plain text encrypted successfully and ready to send\n");
    }
    public void setEnCipher(Cipher enCipher) {
        this.enCipher = enCipher;
    }
    

}