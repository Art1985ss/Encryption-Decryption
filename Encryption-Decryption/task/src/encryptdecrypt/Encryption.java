package encryptdecrypt;

public abstract class Encryption {
    protected StringBuilder stringBuilder;

    abstract String encrypt(String data, int key);

    abstract String decrypt(String data, int key);

    public String encryption(String mode, String data, int key) {
        switch (mode) {
            case "enc":
                data = encrypt(data, key);
                break;
            case "dec":
                data = decrypt(data, key);
                break;
            default:
                System.out.println("Error : invalid mode argument");
        }
        return data;
    }

    public static Encryption create(String algorithm) {
        if ("shift".equals(algorithm)) {
            return new ShiftEncryption();
        } else if ("unicode".equals(algorithm)) {
            return new UnicodeEncryption();
        }
        return null;
    }


}
