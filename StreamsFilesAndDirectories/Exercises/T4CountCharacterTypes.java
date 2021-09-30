package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.Set;

public class T4CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects" +
                "\\ProgrammingAdvancedWithJava\\src\\StreamsFilesAndDirectories\\Exercises\\input.txt";

        String fileToWrite = "D:\\Documents_Valio\\JavaProjects\\IdeaProjects\\ProgrammingAdvancedWithJava" +
                "\\src\\StreamsFilesAndDirectories\\Exercises\\output4.txt";

        BufferedReader reader = new BufferedReader(new FileReader(path));
        PrintWriter writer = new PrintWriter(new FileWriter(fileToWrite));

        String line = reader.readLine();
        Set<Character> vowels = Set.of('u', 'a', 'e', 'i', 'o');
        Set<Character> punctuation = Set.of('!', ',', '.', '?');

        int vowelsCount = 0;
        int consonantsCount = 0;
        int punctuationCount = 0;

        while (line != null) {
            for (int i = 0; i < line.length(); i++) {
                char currentChar = line.charAt(i);
                if (vowels.contains(currentChar)) {
                    vowelsCount++;
                } else if (punctuation.contains(currentChar)) {
                    punctuationCount++;
                } else if (currentChar == ' ') {
                    continue;
                } else {
                    consonantsCount++;
                }
            }
            line = reader.readLine();
        }

        writer.printf("Vowels: %d%nConsonants: %d%nPunctuation: %d%n", vowelsCount, consonantsCount, punctuationCount);
        writer.close();
    }
}
