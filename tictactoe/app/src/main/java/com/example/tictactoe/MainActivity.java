package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //0 : cross , 1: circle ,2: empty
    int active = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions= {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive =true;
    @SuppressLint("SetTextI18n")
    public void dropIn(View view) {

            ImageView counter = (ImageView) view;
            int tappedCounter = Integer.parseInt(counter.getTag().toString());
            if (gameState[tappedCounter] == 2 && gameActive) {
                gameState[tappedCounter] = active;
                counter.setTranslationY(-1500);
                if (active == 1) {
                    active = 0;
                    counter.setImageResource(R.drawable.cross);
                } else {
                    active = 1;
                    counter.setImageResource(R.drawable.circle);
                }
                counter.animate().translationYBy(1500).rotation(360).setDuration(300);

                for (int[] winningPosition : winningPositions) {
                    if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                        gameActive = false;
                        String winner;
                        if (active == 0)
                            winner = "cross";
                        else
                            winner = "circle";

                        Button playAgainButton = findViewById(R.id.playAgainButton);
                        TextView winnerTextView = findViewById(R.id.winnerTextView);
                        winnerTextView.setText("winner is "+winner);
                        playAgainButton.setVisibility(View.VISIBLE);
                        winnerTextView.setVisibility(View.VISIBLE);

                    }

                }
            }
        }
    Button playAgainButton;
    TextView winnerTextView;
    public void playAgain(View view){
        playAgainButton = findViewById(R.id.playAgainButton);
        winnerTextView = findViewById(R.id.winnerTextView);

        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0; i<gridLayout.getChildCount(); i++) {

            ImageView counter = (ImageView) gridLayout.getChildAt(i);

            counter.setImageDrawable(null);

        }
        active = 0;
        Arrays.fill(gameState, 2);
        gameActive =true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playAgainButton = findViewById(R.id.playAgainButton);
        TextView winnerTextView = findViewById(R.id.winnerTextView);
    }
}
