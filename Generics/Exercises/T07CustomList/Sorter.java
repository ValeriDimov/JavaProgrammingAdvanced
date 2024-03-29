package Generics.Exercises.T07CustomList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Sorter {

    public static <T extends Comparable<T>> void sort(CustomList<T> customList){
        for (int i = 0; i < customList.size(); i++) {
            T element = customList.get(i);
            for (int j = i+1; j < customList.size(); j++) {
                T nextElement = customList.get(j);
                if(element.compareTo(nextElement) > 0){
                    customList.swap(i, j);
                }
            }
        }
    }
}