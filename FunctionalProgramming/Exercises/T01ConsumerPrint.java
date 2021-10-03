package FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class T01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringsArr = (scanner.nextLine().split("\\s+"));
        Consumer<String> printNames = name -> System.out.println(name);

  //      Arrays.stream(stringsArr).forEach(printNames);
        for (String name :stringsArr) {
            printNames.accept(name);
        }
    }
}
