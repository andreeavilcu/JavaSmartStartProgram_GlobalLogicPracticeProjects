package org.example;


import java.util.Map;

public class Student {
    private String studentName;
    private Map<String, Double> courses;

    public Student(String name, Map<String,Double> courses){
        this.studentName = name;
       this.courses = courses;
    }

    public double calculateAverageGrade(){
        if (courses == null || courses.isEmpty()){
            return 0.0;
        }

        double sum = 0.0;
        for( double grade : courses.values()){
            sum += grade;
        }

        return sum/courses.size();
    }

    public String getStudentName() {
        return studentName;
    }

    public Map<String, Double> getCourses() {
        return courses;
    }
}
