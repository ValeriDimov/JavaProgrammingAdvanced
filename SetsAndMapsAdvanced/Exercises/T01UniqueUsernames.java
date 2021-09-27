package SetsAndMapsAdvanced.Exercises;

import com.sun.source.doctree.SeeTree;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class T01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> usernames = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String username = scanner.nextLine();
            usernames.add(username);
        }
        System.out.println(String.join(System.lineSeparator(), usernames));
    }
}
