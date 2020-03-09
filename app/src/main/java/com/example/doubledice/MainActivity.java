package com.example.doubledice;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {
private static final String TAG = "MainActivity";
private static final Random random = new Random();
    AnimationDrawable diceAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView diceOne = findViewById(R.id.diceOne);
        final TextView diceTwo = findViewById(R.id.diceTwo);
        final TextView sum = findViewById(R.id.sum);
        final ImageView imageOne = findViewById(R.id.imageOne);
        final ImageView imageTwo = findViewById(R.id.imageTwo);


        final Button roll = findViewById(R.id.roll);
        roll.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                roll.setVisibility(View.INVISIBLE);
                prepareDice(imageOne);
                prepareDice(imageTwo);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        rollDice(sum, diceOne, diceTwo, imageOne, imageTwo);
                        roll.setVisibility(View.VISIBLE);
                    }
                }, 1500);

               Log.d(TAG, "Dice rolled");
            }
        });
        Log.d(TAG, "onCreate: Completed");
    }

    private void rollDice(TextView one, TextView two, TextView three, ImageView imageOne, ImageView imageTwo){
        int num1 = getNumber();
        int num2 = getNumber();
        one.setText(Integer.toString(num1+num2));
        two.setText(Integer.toString(num1));
        three.setText(Integer.toString(num2));
        setDice(num1, imageOne);
        setDice(num2, imageTwo);
    }

    private int getNumber(){
        int number = 0;
        //number = ThreadLocalRandom.current().nextInt(1, 7);
        number = random.nextInt(6) + 1;
        return number;
    }

    private void setDice(int number, ImageView image){
        switch(number){
            case 1:
                image.setImageResource(R.drawable.one);
                break;
            case 2:
                image.setImageResource(R.drawable.two);
                break;
            case 3:
                image.setImageResource(R.drawable.three);
                break;
            case 4:
                image.setImageResource(R.drawable.four);
                break;
            case 5:
                image.setImageResource(R.drawable.five);
                break;
            case 6:
                image.setImageResource(R.drawable.six);
                break;
        }
    }

    private void setDice(int number, View image){
        switch(number){
            case 1:
                image.setBackgroundResource(R.drawable.one);
                break;
            case 2:
                image.setBackgroundResource(R.drawable.two);
                break;
            case 3:
                image.setBackgroundResource(R.drawable.three);
                break;
            case 4:
                image.setBackgroundResource(R.drawable.four);
                break;
            case 5:
                image.setBackgroundResource(R.drawable.five);
                break;
            case 6:
                image.setBackgroundResource(R.drawable.six);
                break;
        }
    }

    private void prepareDice(final ImageView image){
        image.setImageResource(android.R.color.transparent);
        image.setBackgroundResource(android.R.color.transparent);
        image.setBackgroundResource(R.drawable.animation);
        diceAnimation = (AnimationDrawable) image.getBackground();
        Log.d(TAG, "Animation Starting");
        diceAnimation.start();


            //image.setBackgroundResource(android.R.color.transparent);


    }
}
