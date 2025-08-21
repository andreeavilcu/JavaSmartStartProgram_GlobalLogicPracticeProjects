package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListExample {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(42);
        numbers.add(10);
        numbers.add(35);
        numbers.add(7);
        numbers.add(88);

        System.out.println("Original ArrayList: " + numbers);

        numbers.remove(2);
        System.out.println("After removing element at index 2: " + numbers);

        int elementToCheck = 10;
        if(numbers.contains(elementToCheck)){
            System.out.println(elementToCheck + " exists in the ArrayList.");
        } else {
            System.out.println(elementToCheck + " does not exist in the ArrayList.");
        }

        Collections.sort(numbers);

        System.out.println("Sorted ArrayList: " + numbers);

    }
}
