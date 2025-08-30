package com.football.demo.model;

public class ScoreResponse {
    private int score;
    private String grade;


    public ScoreResponse(int score, String grade) {
        this.score = score;
        this.grade = grade;
    }


    public int getScore() {
        return score;
    }

    public String getGrade() {
        return grade;
    }
}
