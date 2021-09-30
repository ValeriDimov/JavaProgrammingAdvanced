package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class T2SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\input.txt";

        long sum = 0;
        for(byte value : Files.readAllBytes(Path.of(path))){
            if (value != 10 && value != 13){
                sum += value;
            }
        }

        System.out.println(sum);
    }
}
