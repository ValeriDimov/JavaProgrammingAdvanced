package SetsAndMapsAdvanced.Exercises;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebook = new HashMap<>();

        while (!input.equals("search")) {
            String[]namesAndPhonesArr = input.split("-");
            String name = namesAndPhonesArr[0];
            String phone = namesAndPhonesArr[1];

            phonebook.put(name, phone);

            input = scanner.nextLine();
        }
        String diffNames = scanner.nextLine();
        while (!diffNames.equals("stop")) {
            if (phonebook.containsKey(diffNames)) {
                System.out.printf("%s -> %s%n", diffNames, phonebook.get(diffNames));
            } else {
                System.out.printf("Contact %s does not exist.%n", diffNames);
            }
            diffNames = scanner.nextLine();
        }
    }
}
