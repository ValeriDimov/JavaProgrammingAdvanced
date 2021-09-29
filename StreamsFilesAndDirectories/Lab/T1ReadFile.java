package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;

public class T1ReadFile {
    public static void main(String[] args) throws IOException {

        String root = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\input.txt";

        FileInputStream fileStream = new FileInputStream(root);

        int value = fileStream.read();

        while (value != -1) {
            System.out.printf("%s ", Integer.toBinaryString(value));

            value = fileStream.read();
        }
    }
}
