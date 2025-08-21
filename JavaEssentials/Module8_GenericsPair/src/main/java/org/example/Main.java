package org.example;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static <T, U> Pair<U, T> swap(Pair<T, U> pair) {
        return new Pair<>(pair.getSecond(), pair.getFirst());
    }

    public static void printPair(Pair<?, ?> pair){
        System.out.println("First: " + pair.getFirst() + " | Second: " + pair.getSecond());
    }

    public static void main(String[] args){
        Pair<String, Integer> p1 = new Pair<>("Hello", 123);
        printPair(p1);

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(10);
        list2.add(20);

        Pair<ArrayList<String>, ArrayList<Integer>> p2 = new Pair<>(list1, list2);
        printPair(p2);

        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");

        HashSet<Double> set = new HashSet<>();
        set.add(1.5);
        set.add(2.5);

        Pair<HashMap<Integer, String>, HashSet<Double>> p3 = new Pair<>(map, set);
        printPair(p3);

        System.out.println("Before swap p1: " + p1);
        Pair<Integer, String> swapped = swap(p1);
        System.out.println("After swap p1: " + swapped);


    }


}