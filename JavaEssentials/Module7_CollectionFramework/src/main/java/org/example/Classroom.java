package org.example;

import java.util.Set;

public class Classroom {
    private Set<Student> students;

    public double calculateAverageClassGrade(){
        if (students == null || students.isEmpty()){
            return 0.0;
        }
        double sum = 0.0;
        int count = 0;

        for (Student student : students){
            sum = sum + student.calculateAverageGrade();
            count ++;
        }

        return count == 0 ? 0.0 : sum / count;

    }

    public Classroom(Set<Student> students) {
        this.students = students;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
