package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EncryptionService {
    private String data = "";
    private String mode = "enc";
    private int key = 0;
    private String outFilePath;
    private String inFilePath;
    private String algorithm = "shift";

    public EncryptionService(String[] args) {
        getArguments(args);
    }

    private void getArguments(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            switch (args[i]) {
                case "-mode":
                    mode = args[i + 1];
                    continue;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    continue;
                case "-data":
                    data = args[i + 1];
                    continue;
                case "-in":
                    inFilePath = args[i + 1];
                    continue;
                case "-out":
                    outFilePath = args[i + 1];
                    continue;
                case "-alg":
                    algorithm = args[i + 1];
                    continue;
                default:
            }
        }
    }

    public void process() {
        if ("".equals(data) && inFilePath != null) {
            data = readFile(inFilePath);
        }
        Encryption encryption = Encryption.create(algorithm);
        assert encryption != null;
        data = encryption.encryption(mode, data, key);
        if (outFilePath != null) {
            writeFile(outFilePath, data);
        } else {
            System.out.println(data);
        }
    }


    private String readFile(String filepath) {
        String text = "";
        try {
            text = Files.readString(Paths.get(filepath));
        } catch (IOException e) {
            System.out.println("Error : file couldn't be read.");
        }
        return text;
    }

    private void writeFile(String filepath, String data) {
        try (FileWriter fileWriter = new FileWriter(filepath)) {
            fileWriter.write(data);
        } catch (Exception e) {
            System.out.println("Error : file couldn't be written!");
        }
    }
}
