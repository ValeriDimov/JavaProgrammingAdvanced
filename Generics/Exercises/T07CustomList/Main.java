package Generics.Exercises.T07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String commands = scanner.nextLine();
        CustomList<String> stringCustomList = new CustomList<>();

        while (!commands.equals("END")) {
            String[] commandsArr = commands.split("\\s+");
            String currentCommand = commandsArr[0];

//•	Max - Prints the maximum element in the list.
//•	Min - Prints the minimum element in the list.
//•	Print - Prints all elements in the list, each on a separate line.
//•	END - stops the reading of commands.

            switch (currentCommand) {
                case "Add":
                    String element = commandsArr[1];
                    stringCustomList.add(element);
                    break;
                case "Remove":
                    int index = Integer.parseInt(commandsArr[1]);
                    stringCustomList.remove(index);
                    break;
                case "Contains":
                    String elementC = commandsArr[1];
                    System.out.println(stringCustomList.contains(elementC));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(commandsArr[1]);
                    int secondIndex = Integer.parseInt(commandsArr[2]);
                    stringCustomList.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    String elementG = commandsArr[1];
                    System.out.println(stringCustomList.countGreaterThan(elementG));
                    break;
                case "Max":
                    System.out.println(stringCustomList.getMax());
                    break;
                case "Min":
                    System.out.println(stringCustomList.getMin());
                    break;
                case "Print":
                    System.out.println(stringCustomList);
                    break;
                case "Sort":
                    Sorter.sort(stringCustomList);
                    break;
            }

            commands = scanner.nextLine();
        }
    }
}
