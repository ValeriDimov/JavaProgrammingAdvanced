package SetsAndMapsAdvanced.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class T02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String guests = scanner.nextLine();
        Set<String> invitedGuests = new TreeSet<>();

        while (!guests.equals("PARTY")) {
            invitedGuests.add(guests);
            guests = scanner.nextLine();
        }
        guests = scanner.nextLine();
        while (!guests.equals("END")) {
            invitedGuests.remove(guests);

            guests = scanner.nextLine();
        }
        System.out.println(invitedGuests.size());
        System.out.println(String.join(System.lineSeparator(), invitedGuests));
    }
}
