package com.example.medievaltunes;

public class Question {
    private int id, correct, tune;
    private String  question, response1, response2, response3, response4;

    public Question(int id, int correct, int tune, String question, String response1, String response2, String response3, String response4) {
        this.id = id;
        this.correct = correct;
        this.tune = tune;
        this.question = question;
        this.response1 = response1;
        this.response2 = response2;
        this.response3 = response3;
        this.response4 = response4;
    }

    public int getId() {
        return id;
    }

    public int getCorrect() {
        return correct;
    }

    public int getTune() {
        return tune;
    }

    public String getQuestion() {
        return question;
    }

    public String getResponse1() {
        return response1;
    }

    public String getResponse2() {
        return response2;
    }

    public String getResponse3() {
        return response3;
    }

    public String getResponse4() {
        return response4;
    }
}
