package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Encryption {
    private String data;
    private String mode = "enc";
    private int key = 0;
    private String outFilePath;
    private String inFilePath;

    public Encryption(String[] args) {
        getArguments(args);
        if (data == null) {
            if (inFilePath != null) {
                readFile();
            } else {
                data = "";
            }
        }
    }

    private void getArguments(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    data = args[i + 1];
                    break;
                case "-in":
                    inFilePath = args[i + 1];
                    break;
                case "-out":
                    outFilePath = args[i + 1];
                    break;
                default:
            }
        }
    }

    public void encryption() {
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
        if (outFilePath != null) {
            writeFile();
        } else {
            System.out.println(data);
        }
    }

    public static String encrypt(String data, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            ch += key;
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static String decrypt(String data, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            ch -= key;
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    private void readFile() {
        String text = "";
        try {
            text = Files.readString(Paths.get(inFilePath));
        } catch (IOException e) {
            System.out.println("Error : file couldn't be read.");
        }
        data = text;
    }

    private void writeFile() {
        try (FileWriter fileWriter = new FileWriter(outFilePath)) {
            fileWriter.write(data);

        } catch (Exception e) {
            System.out.println("Error : file couldn't be written!");
        }
    }
}

