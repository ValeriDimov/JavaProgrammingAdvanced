package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class T3CopyBytes {
    public static void main(String[] args) throws IOException {

        String fileToRead = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
        "\\src\\StreamsFilesAndDirectories\\Lab\\input.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\output3.txt";

        FileInputStream fileInput = new FileInputStream(fileToRead);
        FileOutputStream fileOutput = new FileOutputStream(fileToWrite);

        int value = fileInput.read();

        while (value != -1) {
            char symbol = (char) (value);
            if (value == 10 || value == 32) {
                fileOutput.write(symbol);

            } else {
                String digits = String.valueOf(value);
                for (int i = 0; i < digits.length(); i++) {
                    int currentDigit = digits.charAt(i);
                    fileOutput.write(currentDigit);
                }
            }

            value = fileInput.read();
        }
        fileOutput.close();
    }
}
