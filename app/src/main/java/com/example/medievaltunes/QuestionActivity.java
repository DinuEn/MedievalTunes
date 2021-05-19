package com.example.medievaltunes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{

    private List<Question> questionList = null;
    private List<TextView> answerList = new ArrayList<TextView>();
    private int currentQuestionPosition = 0;
    private int selectedAnswer = 0;//just a flag
    private int readyToSubmit = 0;//just a flag
    private int score = 0;//number of correct answers
    private ResultsData data;
    public static MediaPlayer mMediaPlayer = new MediaPlayer();
    private Button button = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecran_intrebare);

        data = ResultsData.getInstance();
        questionList = QuestionGenerator.generateQuestions();
        setCurrentQuestion();
        button = (Button) findViewById(R.id.submit_answer_button);



        answerList.get(0).setOnClickListener(this);
        answerList.get(1).setOnClickListener(this);
        answerList.get(2).setOnClickListener(this);
        answerList.get(3).setOnClickListener(this);
        button.setOnClickListener(this);



    }

    private void setCurrentQuestion(){
        setSong();
        setAnswerDefault();

        Question currentQuestion =  questionList.get(currentQuestionPosition);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress_bar);//progress bar from xml file
        progressBar.setProgress(currentQuestionPosition);//modify by current question

        TextView progressText = (TextView) findViewById(R.id.progress_text);//progress bar textview element from xml file
        progressText.setText(currentQuestionPosition + "/" + progressBar.getMax());//modify by current question
        data.setNumberOfQuestions(progressBar.getMax());

        TextView questionText = (TextView) findViewById(R.id.question);
        questionText.setText(currentQuestion.getQuestion());

        //set values of TextView answer elements
        TextView answerText1 = (TextView) findViewById(R.id.answer1_text);
        answerText1.setText(currentQuestion.getResponse1());
        answerList.add(answerText1);

        TextView  answerText2 = (TextView) findViewById(R.id.answer2_text);
        answerText2.setText(currentQuestion.getResponse2());
        answerList.add(answerText2);

        TextView answerText3 = (TextView) findViewById(R.id.answer3_text);
        answerText3.setText(currentQuestion.getResponse3());
        answerList.add(answerText3);

        TextView answerText4 = (TextView) findViewById(R.id.answer4_text);
        answerText4.setText(currentQuestion.getResponse4());
        answerList.add(answerText4);


    }

    private void setAnswerDefault(){
        for(TextView answer : answerList){
            answer.setBackgroundResource(R.drawable.answer_background);
        }
    }

    private void setSelectedAnswer(int Answer){
        setAnswerDefault();

        if(Answer == answerList.get(0).getId()) {
            answerList.get(0).setBackgroundResource(R.drawable.selected_answer_background);
            selectedAnswer = 1;
        }

        if(Answer == answerList.get(1).getId()){
            answerList.get(1).setBackgroundResource(R.drawable.selected_answer_background);
            selectedAnswer = 2;
        }

        if(Answer == answerList.get(2).getId()) {
            answerList.get(2).setBackgroundResource(R.drawable.selected_answer_background);
            selectedAnswer = 3;
        }
        if(Answer == answerList.get(3).getId()) {
            answerList.get(3).setBackgroundResource(R.drawable.selected_answer_background);
            selectedAnswer = 4;
        }
        if(Answer == button.getId()){
            submitAnswer(selectedAnswer);
        }
    }

    private void submitAnswer(int selectedAnswer){

        System.out.println("currentQuestionPosition");
        Button button = (Button) findViewById(R.id.submit_answer_button);
        if(readyToSubmit == 0) { //an answer has just been submitted
            int correctAnswerID = questionList.get(currentQuestionPosition).getCorrect();

            if (selectedAnswer == correctAnswerID) { // the answer matches the correct id for the question, is thus correct
                answerList.get(selectedAnswer - 1).setBackgroundResource(R.drawable.correct_answer_background);
                score++;
            }
            else { //wrong answer has been selected
                answerList.get(selectedAnswer - 1).setBackgroundResource(R.drawable.wrong_answer_background);
                answerList.get(correctAnswerID - 1).setBackgroundResource(R.drawable.correct_answer_background);
            }
            readyToSubmit = 1;

            if (currentQuestionPosition < (questionList.size() - 1) ) { //if this is not the last question, show go to next question
                button.setText("GO TO NEXT QUESTION");
            }
            else if (currentQuestionPosition == (questionList.size() - 1)) { //if it is indeed the last question, have the option to finish
                button.setText("FINISH");
            }
            return;
        }

        if(readyToSubmit == 1) { //an answer is waiting to be submitted

            if (currentQuestionPosition < (questionList.size() - 1) ) { //this is not the last question, so go to a new question
                currentQuestionPosition++;
                setCurrentQuestion();
                button.setText("SUBMIT");
            } else if (currentQuestionPosition == (questionList.size() - 1)) { //this is the last question, so the finish button has already been pressed
                data.setScore(score);
                Intent intent = new Intent(this, ResultsActivity.class);
                startActivity(intent);
                finish();
            }
            readyToSubmit = 0;
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        setSelectedAnswer(id);
    }

    private void setSong(){
        mMediaPlayer.stop();
        switch (questionList.get(currentQuestionPosition).getTune()){
            case 1:
                mMediaPlayer = MediaPlayer.create(this, R.raw.pumped);
                break;

            case 2:
                mMediaPlayer = MediaPlayer.create(this, R.raw.fear);
                break;

            case 3:
                mMediaPlayer = MediaPlayer.create(this, R.raw.round);
                break;
        }


        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //mMediaPlayer.setLooping(true);
        mMediaPlayer.start();
    }
}
