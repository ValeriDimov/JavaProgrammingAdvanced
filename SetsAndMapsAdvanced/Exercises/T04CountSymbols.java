package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> charactersCounts = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char tempChar = input.charAt(i);

            if (!charactersCounts.containsKey(tempChar)) {
                charactersCounts.put(tempChar, 1);
            } else {
                int tempCount = charactersCounts.get(tempChar);
                charactersCounts.put(tempChar, tempCount + 1);
            }
        }
        charactersCounts.entrySet().forEach(el -> {
            System.out.printf("%s: %d time/s%n", el.getKey(), el.getValue());
        });
    }
}
