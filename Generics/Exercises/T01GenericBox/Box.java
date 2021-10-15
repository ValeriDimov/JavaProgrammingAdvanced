package Generics.Exercises.T01GenericBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T extends Comparable<T>> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return elements;
    }

    public void swapElements(int firstElement, int secondElement){
        Collections.swap(elements, firstElement, secondElement);
    }

    public int countOfGraterElements(T elementToCompare) {
       return (int) elements.stream().filter(e -> e.compareTo(elementToCompare) > 0).count();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
//        java.lang.String: life in a box
        for (T element : elements) {
            result.append(element.getClass().getName()).append(": ")
                    .append(element).append(System.lineSeparator());
        }
        String stringForPrint = result.toString();
        return stringForPrint;
    }
}



