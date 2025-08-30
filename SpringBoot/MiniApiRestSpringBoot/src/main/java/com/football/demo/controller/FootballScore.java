package com.football.demo.controller;

import com.football.demo.model.ScoreRequest;
import com.football.demo.model.ScoreResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class FootballScore {

    @GetMapping("/score")
    public String getScore(@RequestParam int value){
        String result;

        if (value >= 90){
            result = "Excellent! Your score is " + value;
        }
        else if (value >= 75){
            result = "Good! Your score is " + value;
        }
        else if(value > 50) {
            result = "Average. Your score is " + value;
        }
        else {
            result = "Fail. Your score is " + value;
        }

        return result;
    }

    @PostMapping("/scores")
    public ScoreResponse generateScore(@RequestBody ScoreRequest request){
        int value = request.getValue();
        String grade;

        if (value >= 90) {
            grade = "Excellent";
        } else if (value >= 75) {
            grade = "Good";
        } else if (value >= 50) {
            grade = "Average";
        } else {
            grade = "Fail";
        }

        return new ScoreResponse(value, grade);

    }
}
