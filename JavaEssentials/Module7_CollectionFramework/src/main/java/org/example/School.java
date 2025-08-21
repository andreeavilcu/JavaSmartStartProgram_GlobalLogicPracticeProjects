package org.example;

import java.util.List;

public class School {
    private List<Classroom> classrooms;


    public School(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public double calculateAverageSchoolGrade(){
        if (classrooms == null || classrooms.isEmpty()) {
            return 0.0;
        }

        double sum = 0.0;
        int count = 0;

        for(Classroom classroom : classrooms){
            count++;
            sum += classroom.calculateAverageClassGrade();
        }

        return count == 0 ? 0.0 : sum/count;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }
}
