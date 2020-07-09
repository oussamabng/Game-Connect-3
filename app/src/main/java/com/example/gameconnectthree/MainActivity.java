package com.example.gameconnectthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 0 is yellow , 1 is red , 2 empty

    int[] gameState = {2,2,2,2,2,2,2,2,2};

    // the all possibilities to win
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int activePlayer = 0;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        gameState[tappedCounter] = activePlayer;

        // check if imageView dont have an image attached
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
                    Toast.makeText(this, winner + " has won!", Toast.LENGTH_SHORT).show();

                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}