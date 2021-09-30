package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class T6WordCount {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\words.txt";
        String pathInputFile = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\text.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Exercises\\results.txt";

        String[] wordsList = Files.readString(Path.of(path)).split("\\s+");
//        List<String> inputWordsList = new ArrayList<>();
//        Collections.addAll(inputWordsList, wordsList);

        Map<String, Integer> output = new HashMap<>();

        for (String word : wordsList) {
            output.put(word, 0);
        }
        BufferedReader reader = new BufferedReader(new FileReader(pathInputFile));
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite));

        String line = reader.readLine();

        while (line != null) {
            String[] arr = line.split("\\s+");
            for (String el : arr) {
                if (output.containsKey(el)) {
                    int tempQuantity = output.get(el);
                    output.put(el, tempQuantity + 1);
                }
            }
            line = reader.readLine();
        }
        output.entrySet()
                .stream()
                .sorted((el1, el2) -> el2.getValue().compareTo(el1.getValue()))
                .forEach(stringIntegerEntry -> writer.printf("%s - %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue()));

        writer.close();
    }
}
