package Ciphers;

public interface Cipher{
    public String getName();
    public void PlainTexttoBlocks();
    public void ProcessEachBlock();
    public void GenerateCipher();
}