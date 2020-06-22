package encryptdecrypt;

public class UnicodeEncryption extends Encryption {
    @Override
    public String encrypt(String data, int key) {
        stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            ch += key;
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    @Override
    public String decrypt(String data, int key) {
        stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            ch -= key;
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
