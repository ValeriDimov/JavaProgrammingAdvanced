package StreamsFilesAndDirectories.Exercises;

import java.io.*;

public class T3AllCapitals {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\input.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Exercises\\output3.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite));

        String line = reader.readLine();

        while (line != null ) {
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (Character.isAlphabetic(currentChar)) {
                    char newCurrentChar = Character.toUpperCase(currentChar);
                    writer.print(newCurrentChar);
                } else {
                    writer.print(currentChar);
                }
            }
            writer.print(System.lineSeparator());
            line = reader.readLine();
        }
        writer.close();
    }
}
