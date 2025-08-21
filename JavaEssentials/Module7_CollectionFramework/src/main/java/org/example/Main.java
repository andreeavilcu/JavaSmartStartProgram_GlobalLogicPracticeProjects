package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("Mihai", Map.of("Math", 90.0, "Physics", 80.0));
        Student s2 = new Student("Andrei", Map.of("Math", 100.0, "Physics", 70.0));
        Student s3 = new Student("Adriana", Map.of("Math", 80.0, "Physics", 80.0));

        Classroom c1 = new Classroom(new HashSet<>(Arrays.asList(s1,s2,s3)));

        Student s4 = new Student("Marius", Map.of("Math", 90.0, "Physics", 80.0));
        Student s5 = new Student("Ana", Map.of("Math", 100.0, "Physics", 70.0));
        Student s6 = new Student("Adrian", Map.of("Math", 81.0, "Physics", 80.0));

        Classroom c2 = new Classroom(new HashSet<>(Arrays.asList(s4,s5,s6)));

        School school = new School(Arrays.asList(c1,c2));

        System.out.println("Mihai's average: " + s1.calculateAverageGrade());
        System.out.println("Classroom 1 average: " + c1.calculateAverageClassGrade());
        System.out.println("School average: " + school.calculateAverageSchoolGrade());
    }
}