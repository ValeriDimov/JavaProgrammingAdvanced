package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class T5WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String fileToRead = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\input.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\output5.txt";

       // Scanner scanner = new Scanner(new FileInputStream(fileToRead));
        BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite));
        //BufferedWriter writer = new BufferedWriter(new FileWriter(fileToWrite));
        int lines = 1;
        String line = reader.readLine();

        while (line != null) {
            if (lines % 3 == 0) {
                writer.println(line);
            }
            lines++;
            line = reader.readLine();
        }
        writer.close();
    }
}
