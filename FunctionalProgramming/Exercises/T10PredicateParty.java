package FunctionalProgramming.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class T10PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String line = scanner.nextLine();



        while (!line.equals("Party!")){

            Predicate<String> predicate = null;

            String criteria = line.split("\\s+")[2];

            if(line.contains("Length")){
                predicate = x -> x.length() == Integer.parseInt(criteria);
            }else if(line.contains("StartsWith")){
                predicate = x -> x.startsWith(criteria);
            }else{
                predicate = x -> x.endsWith(criteria);
            }

            if(line.contains("Remove")){
                ArrayList<String> toRemove = new ArrayList<>();
                for (String guest : guests) {
                    if(predicate.test(guest)){
                        toRemove.add(guest);
                    }
                }

                guests.removeAll(toRemove);
            }else{
                ArrayList<String> toAdd = new ArrayList<>();
                for (String guest : guests) {
                    if(predicate.test(guest)){
                        toAdd.add(guest);
                    }
                }
                guests.addAll(toAdd);
            }

            line = scanner.nextLine();
        }

        if(guests.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else{
            System.out.println(guests.stream().sorted().collect(Collectors.toCollection(ArrayList::new)).toString().replaceAll("([\\[\\]])", "") + " are going to the party!");
        }
    }
}
