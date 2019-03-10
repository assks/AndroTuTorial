package com.firebasedemo.www.andro_tut;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CQuizz extends AppCompatActivity {

    Button b1,b2,b3,bnext,bresult;
    TextView ques;
    TextView textView,time;
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private final long startTime = 20 * 1000;
    private final long interval = 1 * 1000;

    int flag=0;
    public static int marks,correct=0,wrong;

    String question[]={"1-Who developed C?","2-C is _______ language?","3-How to comment in C language?","4-Which is not a character of C?","5-Identify the scalar data type in C?",
            "6-Which is an invalid variable name?","7-Choose the correct statement?","8-Smallest element of Array Index is called?","9-The default parameter passing mechanism is ?","10-Use of functions?"};
    String ans[]={"Dennish Ritchei","High Level","Both","$","double","net-total","All of above","Lower Bond","Call by value","All of above"};
    String opt[]={"Dennish Ritchei","Sun Microsystem","Bjarne Stourstrup","Low level","High Level","Machine Level","//Comment","/* Comment */","Both","$","!","^","union","function","double","integer","Xx",
            "net-total","An identifier may start with an underscore","An identifier may end with an underscore","All of above","Lower Bond","Upper Bond","Extraction","Call by reference","Call by value","Call by value result",
            "Helps to avoid repeating a set of statements many times","Enhance the logical clarity of the program","All of above"};

    ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_quiz);

        ques = (TextView) findViewById(R.id.question);
        b1 = (Button) findViewById(R.id.opt1);
        b2 = (Button) findViewById(R.id.opt2);
        b3 = (Button) findViewById(R.id.opt3);
        bnext = (Button) findViewById(R.id.next_button);
        bresult = (Button) findViewById(R.id.result_button);
        textView = (TextView) findViewById(R.id.correctans);
        time = (TextView) findViewById(R.id.time);
       /* arrayList= new ArrayList<>();

        for (int i=0;i<question.length;i++){
            arrayList.add(question[i]);
        }
        Collections.shuffle(arrayList);*/
       // Random random = new Random();
        //flag = random.nextInt(10);
        ques.setText(question[flag]);
        b1.setText(opt[flag]);
        b2.setText(opt[flag+1]);
        b3.setText(opt[flag+2]);
        if(MainClass.tbflag1) {

            countDownTimer = new CQuizz.MyCountDownTimer(startTime, interval);
            time.setText(time.getText() + String.valueOf(startTime / 1000));
            if (!timerHasStarted) {
                countDownTimer.start();
                timerHasStarted = true;
                // b1.setText("STOP");
            }
        }
       // Animation bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation,R.anim.animation2).toBundle();
       // b1.setAnimation(bndlanimation);
        Animation fadeInAnimation2 = AnimationUtils.loadAnimation(this,R.anim.animation);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
// Now Set your animation
        b1.startAnimation(fadeInAnimation2);
        b2.setAnimation(fadeInAnimation2);
        b3.setAnimation(fadeInAnimation2);
        Animation fadeInAnimation3 = AnimationUtils.loadAnimation(this,R.anim.slide_up);
        ques.setAnimation(fadeInAnimation3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ansText= b1.getText().toString();
                if(ansText.equalsIgnoreCase(ans[flag])){
                    correct++;

                    textView.setText( String.valueOf(correct)+"/10");
                    b1.setBackgroundColor( Color.GREEN);


                }
                else {
                    String anst= b2.getText().toString();
                    if(anst.equalsIgnoreCase(ans[flag])){
                        textView.setText( String.valueOf(correct)+"/10");
                        b2.setBackgroundColor( Color.GREEN);
                    }
                    else
                    {
                        b3.setBackgroundColor( Color.GREEN);
                    }

                    b1.setBackgroundColor( Color.RED);
                }
                b1.setClickable(false);
                b2.setClickable(false);
                b3.setClickable(false);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ansText= b2.getText().toString();
                if(ansText.equalsIgnoreCase(ans[flag])){
                    correct++;
                    textView.setText( String.valueOf(correct)+"/10");
                    b2.setBackgroundColor( Color.GREEN);

                }
                else {
                    String anst= b1.getText().toString();
                    if(anst.equalsIgnoreCase(ans[flag])){
                        textView.setText( String.valueOf(correct)+"/10");
                        b1.setBackgroundColor( Color.GREEN);
                    }
                    else
                    {
                        b3.setBackgroundColor( Color.GREEN);
                    }

                    b2.setBackgroundColor( Color.RED);
                }
                b1.setClickable(false);
                b2.setClickable(false);
                b3.setClickable(false);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ansText= b3.getText().toString();
                if(ansText.equalsIgnoreCase(ans[flag])){
                    correct++;

                   b3.setBackgroundColor( Color.GREEN);
                    textView.setText( String.valueOf(correct)+"/10");

                }
                else {
                    String anst= b1.getText().toString();
                    if(anst.equalsIgnoreCase(ans[flag])){

                        textView.setText( String.valueOf(correct)+"/10");
                        b1.setBackgroundColor( Color.GREEN);
                    }
                    else
                    {
                        b2.setBackgroundColor( Color.GREEN);
                    }

                    b3.setBackgroundColor( Color.RED);
                }
                b1.setClickable(false);
                b2.setClickable(false);
                b3.setClickable(false);

            }
        });

        bnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Random random = new Random();
                //flag = random.nextInt(10);
                b1.setClickable(true);
                b2.setClickable(true);
                b3.setClickable(true);
                b1.setBackgroundColor( Color.GRAY);
                b2.setBackgroundColor( Color.GRAY);
                b3.setBackgroundColor( Color.GRAY);
                Animation fadeInAnimation = AnimationUtils.loadAnimation(CQuizz.this, R.anim.animation);
// Now Set your animation
                b1.startAnimation(fadeInAnimation);
                b2.setAnimation(fadeInAnimation);
                b3.setAnimation(fadeInAnimation);
                flag++;
                if(flag<question.length)
                {
                    // b3.setBackgroundColor(Color.WHITE);
                    ques.setText(question[flag]);
                    b1.setText(opt[flag*3]);
                    b2.setText(opt[(flag*3)+1]);
                    b3.setText(opt[(flag * 3) + 2]);
                }
                else
                {
                   // Toast.makeText(AndroidQuiz.this, "Your score is : "+correct, Toast.LENGTH_SHORT).show();
                    //  Toast.makeText(AndroidQuiz.this, "Your score is : "+correct, Toast.LENGTH_SHORT).show();
                     Intent i = new Intent(CQuizz.this,NewResult.class);
                    String score = String.valueOf(correct);
                    i.putExtra("key",score);
                    startActivity(i);

                }
            }
        });
        bresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(countDownTimer!=null){
                    countDownTimer.cancel();
                }
                if(correct<0)
                {
                    Intent i = new Intent(CQuizz.this,NewResult.class);
                    //i.putExtra("key","");
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(CQuizz.this, NewResult.class);
                    String score = String.valueOf(correct);
                    i.putExtra("key", score);
                    startActivity(i);
                }
            }
        });
    }
    class MyCountDownTimer extends CountDownTimer {
        public MyCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            time.setText("Time's up!");
            if(MainClass.tbflag){
                marks=correct-wrong;
            }
            else{

                marks=correct;
            }
            Intent intent = new Intent(getApplicationContext(),NewResult.class);
            String score = String.valueOf(correct);
            intent.putExtra("key",score);
            startActivity(intent);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            time.setText("Time Start :" + millisUntilFinished / 1000);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
        correct = 0;
        Intent i = new Intent(CQuizz.this,MainClass.class).setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
