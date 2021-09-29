package StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.Scanner;

public class T4ExtractIntegers {
    public static void main(String[] args) throws IOException {

        String fileToRead = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\input.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Lab\\output4.txt";

        //FileInputStream fileInput = new FileInputStream(fileToRead);
        //FileOutputStream fileOutput = new FileOutputStream(fileToWrite);
//        FileReader reader = new FileReader(fileToRead);
//        FileWriter writer = new FileWriter(fileToWrite);

        Scanner scanner = new Scanner(new FileInputStream(fileToRead));
        PrintWriter writer = new PrintWriter(new FileOutputStream(fileToWrite));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        writer.close();
    }
}
