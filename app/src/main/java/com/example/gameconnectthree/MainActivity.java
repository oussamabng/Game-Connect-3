package com.example.gameconnectthree;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 is yellow , 1 is red , 2 empty

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    // the all possibilities to win
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int activePlayer = 0;
    @SuppressLint("SetTextI18n")
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = activePlayer;

        // check if imageView do not have an image attached
        if (counter.getDrawable() == null){
            counter.setTranslationY(-1500);
            if (activePlayer == 0){
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            }
            else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).setDuration(300);
            for(int[] winningPosition : winningPositions){
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[2]] != 2 ){
                    // someone has won
                    String winner = "";
                    if (activePlayer == 0){
                        winner = "Red";
                    }
                    else {
                        winner = "Yellow";
                    }
                    Button playAgainBtn = findViewById(R.id.btnTryAgain);
                    TextView winnerText = findViewById(R.id.winnerText);
                    winnerText.setText(winner+ " has won!");
                    playAgainBtn.setVisibility(View.VISIBLE);
                    winnerText.setVisibility(View.VISIBLE);
                }
            }
        }
    }
    public void reloadGame(View view){
        Button playAgainBtn = findViewById(R.id.btnTryAgain);
        TextView textWinner = findViewById(R.id.winnerText);
        playAgainBtn.setVisibility(View.INVISIBLE);
        textWinner.setVisibility(View.INVISIBLE);

        ImageView image = findViewById(R.id.imageView1);
        ImageView image1 = findViewById(R.id.imageView2);
        ImageView image2 = findViewById(R.id.imageView3);
        ImageView image3 = findViewById(R.id.imageView4);
        ImageView image4 = findViewById(R.id.imageView5);
        ImageView image5 = findViewById(R.id.imageView6);
        ImageView image6 = findViewById(R.id.imageView7);
        ImageView image7 = findViewById(R.id.imageView8);
        ImageView image8 = findViewById(R.id.imageView9);

        image.setImageDrawable(null);
        image1.setImageDrawable(null);
        image2.setImageDrawable(null);
        image3.setImageDrawable(null);
        image4.setImageDrawable(null);
        image5.setImageDrawable(null);
        image6.setImageDrawable(null);
        image7.setImageDrawable(null);
        image8.setImageDrawable(null);

        gameState = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};
        activePlayer = 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}