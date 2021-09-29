package StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class T2WriteToFile {
    public static void main(String[] args) throws IOException {

        String folder = "D:\\Documents_Valio\\JavaProjects" +
                "\\IdeaProjects\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Lab\\input.txt";

        String folderOutput = "D:\\Documents_Valio\\JavaProjects" +
                "\\IdeaProjects\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Lab\\output.txt";

        FileInputStream fileStream = new FileInputStream(folder);
        FileOutputStream fileOutputStream = new FileOutputStream(folderOutput);

        int value = fileStream.read();
        Set<Character> punctuation = Set.of('.', ',', '!', '?');

        while (value != -1) {
            char symbol = (char) value;
           if (!punctuation.contains(symbol)) {
               fileOutputStream.write(symbol);
           }
            value = fileStream.read();
        }
        fileOutputStream.close();
    }
}
