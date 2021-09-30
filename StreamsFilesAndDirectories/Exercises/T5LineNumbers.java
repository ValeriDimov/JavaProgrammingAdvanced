package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class T5LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\inputLineNumbers.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Exercises\\output5.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite));

        String line = reader.readLine();
        int lineCount = 1;

        while (line != null) {
            writer.printf("%d. ", lineCount);
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                writer.print(currentChar);
            }
            writer.print(System.lineSeparator());
            lineCount++;
            line = reader.readLine();
        }
        writer.close();
    }
}
