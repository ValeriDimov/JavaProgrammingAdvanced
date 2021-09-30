package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T6SortLines {
    public static void main(String[] args) throws IOException {

        String fileToRead = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\input.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\output6.txt";

        Path path = Path.of(fileToRead);

       // BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(fileToWrite));
        PrintWriter printWriter = new PrintWriter(new FileWriter(fileToWrite));

        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);

        for (int i = 0; i < lines.size(); i++) {
            printWriter.write(lines.get(i));
            printWriter.write(System.lineSeparator());
        }
        printWriter.close();
    }
}
