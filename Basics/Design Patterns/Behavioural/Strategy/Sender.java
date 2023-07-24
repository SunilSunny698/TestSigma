import Ciphers.Aes;
import Ciphers.Des;
import Encryption.Encrypter;

public class Sender {
    public static void main(String[] args) {
        Encrypter cipher = new Encrypter();
        cipher.setEnCipher(new Aes());
        cipher.encrypt("This is plain text");

        cipher.setEnCipher(new Des());
        cipher.encrypt("This is plain text");
    }
}
