package com.example.medievaltunes;

public class ResultsData {
    private static ResultsData instance;
    private int score, numberOfQuestions;
    private String username;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private ResultsData(){

    }

    public static final ResultsData getInstance(){
        if(instance == null){
            instance = new ResultsData();
        }
        return instance;
    }

}
