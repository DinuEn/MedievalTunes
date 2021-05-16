package com.example.medievaltunes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_intrebare);

        List<Question> questionList = QuestionGenerator.generateQuestions();


        int currentQuestionposition = 1;
        for(Question question : questionList){ //get question info one by one

            ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);//progress bar from xml file
            progressBar.setProgress(currentQuestionposition - 1);//modify by current question

            TextView progressText = (TextView) findViewById(R.id.progress_text);//progress bar textview element from xml file
            progressText.setText(currentQuestionposition + "/" + progressBar.getMax());//modify by current question


            TextView questionText = (TextView) findViewById(R.id.question);
            questionText.setText(question.getQuestion());

            //set values of TextView answer elements
            TextView answerText1 = (TextView) findViewById(R.id.answer1_text);
            answerText1.setText(question.getResponse1());

            TextView  answerText2 = (TextView) findViewById(R.id.answer2_text);
            answerText2.setText(question.getResponse2());

            TextView answerText3 = (TextView) findViewById(R.id.answer3_text);
            answerText3.setText(question.getResponse3());

            TextView answerText4 = (TextView) findViewById(R.id.answer4_text);
            answerText4.setText(question.getResponse4());
        }
    }
}