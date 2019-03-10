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

public class AndroidQuiz extends AppCompatActivity {

    Button b1,b2,b3,bnext,bresult;
    TextView ques;
    TextView textView,time;
    private CountDownTimer countDownTimer;
    private boolean timerHasStarted = false;
    private final long startTime = 20 * 1000;
    private final long interval = 1 * 1000;

    int flag=0;
    public static int marks,correct=0,wrong;



    String question[]={"1-First Android Phone?","2-Name of Android version 4.4?","3-What is Android?","4-Is it possible to have an activity without UI to perform action/actions?","5-How to pass the data between activities in Android?",
            "6-How to stop the services in android?","7-What is the time limit of broadcast receiver in android?","8-In which technique we can refresh the dynamic content in android?","9-What is fragment in android?","10-Android is based on which language?"};
    String ans[]={"HTC Desire","kitkat","Mobile_OS","Yes, it is possible","Intent","stopSelf() and stopService()","10 sec","Ajax","Peace of Activity","Java"};
    String opt[]={"Sony","HTC Desire","Samsung","kitkat","lolypop","jellybean","Mobile_OS","Window_OS","iOS","Not possible","Yes, it is possible","Wrong Question","Content Provider","Intent","Broadcast Reciever","finish()","System.exit()",
            "stopSelf() and stopService()","15 sec","10 sec","5 sec","Java","Android","Ajax","Peace of Activity","Layout","JSON","Java","C","C++"};

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

            countDownTimer = new MyCountDownTimer(startTime, interval);
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
                Animation fadeInAnimation = AnimationUtils.loadAnimation(AndroidQuiz.this, R.anim.animation);
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
                     Intent i = new Intent(AndroidQuiz.this,NewResult.class);
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
                    Intent i = new Intent(AndroidQuiz.this,NewResult.class);
                    //i.putExtra("key","");
                    startActivity(i);
                }
                else {

                    Intent i = new Intent(AndroidQuiz.this, NewResult.class);
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
        MainClass.tbflag1 = false;
    }
}
