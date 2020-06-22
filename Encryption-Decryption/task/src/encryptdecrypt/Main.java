package encryptdecrypt;

public class Main {

    public static void main(String[] args) {
        EncryptionService encryptionService = new EncryptionService(args);
        encryptionService.process();
    }
}
