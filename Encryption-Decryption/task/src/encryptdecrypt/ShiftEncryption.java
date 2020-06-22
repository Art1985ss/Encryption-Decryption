package encryptdecrypt;

public class ShiftEncryption extends Encryption {
    private static final int ALPHABET_SIZE = 26;

    @Override
    String encrypt(String data, int key) {
        stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch += key;
                    ch = (char) (ch > 'Z' ? ch - ALPHABET_SIZE : ch);
                } else {
                    ch += key;
                    ch = (char) (ch > 'z' ? ch - ALPHABET_SIZE : ch);
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    @Override
    String decrypt(String data, int key) {
        stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if (Character.isAlphabetic(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch -= key;
                    ch = (char) (ch < 'A' ? ch + ALPHABET_SIZE : ch);
                } else {
                    ch -= key;
                    ch = (char) (ch < 'a' ? ch + ALPHABET_SIZE : ch);
                }
            }
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}

