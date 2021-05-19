package com.example.medievaltunes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface QuestionGenerator {

    //function used to generate the shuffled question list
    static List<Question> generateQuestions(){
        List<Question> questionList = new ArrayList<Question>();
        Question question1 = new Question(1, 1, 1, "Which song is this?", "Pumped up kicks", "What is love", "Zombie", "Bad Romance");
        Question question2 = new Question(2, 3, 2, "Which song is this?", "Losing my Religion", "Paranoid", "Fear of the dark", "Iron Man");
        Question question3 = new Question(3, 2, 3, "Which song is this?", "Take on me", "You spin me right round", "Africa", "Everybody wants to rule the world");
        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        Collections.shuffle(questionList);//Shuffle the questions
        return questionList;//return the shuffled list
    }
}
