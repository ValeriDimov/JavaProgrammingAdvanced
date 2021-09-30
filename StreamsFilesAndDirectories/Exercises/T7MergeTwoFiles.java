package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class T7MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\inputOne.txt";
        String pathInputFile = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\inputTwo.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Exercises\\results7.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        BufferedReader reader2 = new BufferedReader(new FileReader(pathInputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite));

        String line = reader.readLine();
        String line2 = reader2.readLine();

        while (line != null) {
            writer.println(line);
            line = reader.readLine();
        }
        while (line2 != null) {
            writer.println(line2);
            line2 = reader2.readLine();
        }

        writer.close();
    }
}
