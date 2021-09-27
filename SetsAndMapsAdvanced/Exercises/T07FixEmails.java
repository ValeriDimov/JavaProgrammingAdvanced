package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        Map<String, String> namesAndEmailsMap = new LinkedHashMap<>();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();

            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                namesAndEmailsMap.put(name, email);
            }
            name = scanner.nextLine();
        }
        namesAndEmailsMap.entrySet().forEach(el -> System.out.printf("%s -> %s%n", el.getKey(), el.getValue()));
    }
}
