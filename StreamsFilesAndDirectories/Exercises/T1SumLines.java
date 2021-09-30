package StreamsFilesAndDirectories.Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class T1SumLines {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\input.txt";

        Files.readAllLines(Path.of(path)).stream()
                .map(String :: toCharArray)  //str -> str.toCharArray
                .forEach(charArray ->
                {
                    int sum = 0;
                    for (char symbol : charArray) {
                        sum += symbol;
                    }
                    System.out.println(sum);
                });
    }
}