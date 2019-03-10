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

public class JavaQuiz extends AppCompatActivity {

    Button b1,b2,b3,bnext,bresult;
    TextView ques;
    TextView textView,time;
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private final long startTime = 20 * 1000;
    private final long interval = 1 * 1000;


    int flag=0;
    public static int marks,correct=0,wrong;

    private String question[]={"1.Which class cannot be subclassed(or extended) in java","2.Why we use array as a parameter of main method",
            "3.Suspend thread can be revived by using","4.Which keyword is used by method to refer to the object that invoked it?",
            "5.Which operator is used by java runtime implementations to free the memory of an object when it is no longer?",
            "6.Which function is used to perform some action when object is to be destroyed?",
            "7.What is the process of defining a method in terms of itself,that is a method that calls itself",
            "8.Which of these key is used to refer to member of base class from a sub class?",
            "9.A class member declared protected becomes member of sub class of which type?",
            "10.Which of the class is used to create an object whose character sequence is mutable?"};
    private String opt[]={"abstract class","parent class","Final class","it is syntax","can store multiple values",
            "both","start()method","resume()method","yield()method","import","catch","this",
            "delete","new","None","finalize()","delete()","main()","Abstraction","Encapsulation","Recursion",
            "super","this","None","public member","private member","protected member","String{}","StringBuffer{}",
            "both"};
    private String ans[]={"Final class","can store multiple values","resume()method","this","None","finalize()","Recursion","super","private member",
            "StringBuffer{}"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_quiz);

        ques = (TextView) findViewById(R.id.question);
        b1 = (Button) findViewById(R.id.opt1);
        b2 = (Button) findViewById(R.id.opt2);
        b3 = (Button) findViewById(R.id.opt3);
        bnext = (Button) findViewById(R.id.next_button);
       // bresult = (Button) findViewById(R.id.result_button);
        //textView = (TextView) findViewById(R.id.correctans);

        ques.setText(question[flag]);
        b1.setText(opt[0]);
        b2.setText(opt[1]);
        b3.setText(opt[2]);
        if(MainClass.tbflag1) {

            countDownTimer = new JavaQuiz.MyCountDownTimer(startTime, interval);
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
       // Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade);
// Now Set your animation
        b1.startAnimation(fadeInAnimation2);
        b2.setAnimation(fadeInAnimation2);
        b3.setAnimation(fadeInAnimation2);

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
                Animation fadeInAnimation = AnimationUtils.loadAnimation(JavaQuiz.this, R.anim.animation);
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
                    Intent i = new Intent(JavaQuiz.this,NewResult.class);
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
                    Intent i = new Intent(JavaQuiz.this,NewResult.class);
                    //i.putExtra("key","");
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(JavaQuiz.this, NewResult.class);
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
        Intent i = new Intent(JavaQuiz.this,MainClass.class).setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }
}
