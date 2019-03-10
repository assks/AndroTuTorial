package com.firebasedemo.www.andro_tut;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ToggleButton;

public class MainClass extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    public  static Button b4;
    Button b5;
    //TextView t1;

    ToggleButton tg,tg1;
    public static boolean tbflag;
    public static boolean tbflag1;
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private final long startTime = 20 * 1000;
    private final long interval = 1 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_class);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button4);
        b3=(Button)findViewById(R.id.button5);
        b4=(Button)findViewById(R.id.button6);
        b5=(Button)findViewById(R.id.button7);

        tg1=(ToggleButton)findViewById(R.id.toggleButton2);
        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        b1.setAnimation(slideUp);
        b2.setAnimation(slideUp);
        b3.setAnimation(slideUp);
        //Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
        //b4.setAnimation(slideDown);
        //b5.setAnimation(slideDown);
        b4.setAnimation(slideUp);
        b4.setAnimation(slideUp);
        tbflag1 = false;
        //tg1.setChecked(false);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tbflag1=tg1.isChecked();
                AndroidQuiz.correct =0;
                Intent intent = new Intent(getApplicationContext(),AndroidQuiz.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
                //  overridePendingTransition( R.anim.animation, R.anim.animation2 );
                startActivity(intent, bndlanimation);

            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tbflag1=tg1.isChecked();
                JavaQuiz.correct =0;
                Intent intent = new Intent(getApplicationContext(),JavaQuiz.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
                //  overridePendingTransition( R.anim.animation, R.anim.animation2 );
                startActivity(intent, bndlanimation);
               // startActivity(intent);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tbflag1=tg1.isChecked();
                CQuizz.correct =0;
                Intent intent = new Intent(getApplicationContext(),CQuizz.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
                //  overridePendingTransition( R.anim.animation, R.anim.animation2 );
                startActivity(intent, bndlanimation);
               // startActivity(intent);

            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                tbflag1=tg1.isChecked();
                AndroidQuiz.correct =0;
                Intent intent = new Intent(getApplicationContext(),AndroidQuiz.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
                //  overridePendingTransition( R.anim.animation, R.anim.animation2 );
                startActivity(intent, bndlanimation);
                //startActivity(intent);

            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tbflag1=tg1.isChecked();
                PhpQuiz.correct =0;
                Intent intent = new Intent(getApplicationContext(),PhpQuiz.class);
                Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
                //  overridePendingTransition( R.anim.animation, R.anim.animation2 );
                startActivity(intent, bndlanimation);
               // startActivity(intent);
            }
        });
    }
}
