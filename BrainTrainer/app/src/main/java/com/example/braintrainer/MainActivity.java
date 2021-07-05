package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button goButton;
    ConstraintLayout gameLayout;
    ArrayList<Integer> answers = new ArrayList<>();  //store different sum values
    TextView question;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button playAgain;
    TextView time;
    TextView result;
    TextView scoreCard;
    int locationOfCorrectAnswer; //variable to decide the location of correct answer 
    int score = 0, noOfQuestion = 0;

    @SuppressLint("SetTextI18n")
    public void buttonPressed(View view) {
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())) {
            result.setText("Correct");
            score++;
        } else {
            result.setText("Incorrect");
        }
        noOfQuestion++;
        viewResult();
        CreateNSetQuestion();
    }

    @SuppressLint("SetTextI18n")
    public void CreateNSetQuestion() {
        //setting random question
        Random rand = new Random();
        int a = rand.nextInt(21);
        int b = rand.nextInt(21);
        question.setText(a + " + " + b);

        //setting answers
        locationOfCorrectAnswer = rand.nextInt(4); //assign random button
        answers.clear();     // to clear arrayList when reset function is called
        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a + b) {        //checks whether random num assigned to wrongAnswer is not equals to the sum
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }
        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    @SuppressLint("SetTextI18n")
    private void viewResult() {
        scoreCard.setText(score + "/" + noOfQuestion);
    }

    public void go(View view) {
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        timer();
    }

    public void reset(View view) {
        timer(); //resets time
        CreateNSetQuestion();  //resets question and answer options
        score = 0;
        noOfQuestion = 0;
        viewResult(); // resets scorecard to 0/0
        question.setVisibility(View.VISIBLE);
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        result.setText("");
    }

    @SuppressLint("SetTextI18n")
    public void timer() {

        new CountDownTimer(7000, 1000) {
            @Override
            public void onTick(long l) {
                int x = (int) l / 1000;
                time.setText(x + "s");
            }

            @Override
            public void onFinish() {
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                playAgain.setVisibility(View.VISIBLE);
                result.setText("Done!");
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton = findViewById(R.id.GoButton);
        question = findViewById(R.id.question);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        result = findViewById(R.id.result);
        scoreCard = findViewById(R.id.scoreCard);
        CreateNSetQuestion();
        time = findViewById(R.id.time);
        playAgain = findViewById(R.id.playAgain);
        gameLayout = findViewById(R.id.gameLayout);

    }

}
