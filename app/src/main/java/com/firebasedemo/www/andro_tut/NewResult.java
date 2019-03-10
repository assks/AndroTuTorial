package com.firebasedemo.www.andro_tut;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class NewResult extends AppCompatActivity {

    private ProgressBar progBar;
    private TextView text,t;
    private Handler mHandler = new Handler();
    private int mProgressStatus=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_result);
        progBar= (ProgressBar)findViewById(R.id.progressBar);
        text = (TextView)findViewById(R.id.textView);
        t=(TextView)findViewById(R.id.textview);
        //Toast.makeText(this, "working", Toast.LENGTH_SHORT).show();

        Intent i = getIntent();
        String mark = i.getStringExtra("key");
        int marks = Integer.parseInt(mark);
       // Toast.makeText(this, "its calling", Toast.LENGTH_SHORT).show();
        dosomething(marks);
        switch (marks)
        {

            case 0:
                t.setText("Oopsie! try hard work");
                break;
            case 1:
            case 2:
            case 3: t.setText("Oopsie! Better Luck Next Time!");
                break;
            case 4:
            case 5:
            case 6:
            case 7:t.setText("Hmmmm.. Its Good");
                break;
            case 8:
            case 9:
            case 10:t.setText("Excellent.....Good Job");
                break;
        }

        //display score
       // marks =Integer.parseInt(mark);


    }



    public void dosomething(final int marks) {

        new Thread( new Runnable() {
            public void run() {
                final int presentage=0;
                while (mProgressStatus < marks*10) {
                    mProgressStatus += 1;
                    // Update the progress bar
                    mHandler.post(new Runnable() {
                        public void run() {
                            progBar.setProgress(mProgressStatus);
                            text.setText(""+mProgressStatus+"%");
                           // Toast.makeText(NewResult.this, ""+marks, Toast.LENGTH_SHORT).show();

                        }
                    });
                    try {

                        Thread.sleep(100);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }).start();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(NewResult.this,MainClass.class).setFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP);
       // Bundle bndlanimation = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.animation2,R.anim.animation).toBundle();
        //  overridePendingTransition( R.anim.animation, R.anim.animation2 );
        //startActivity(i, bndlanimation);
       startActivity(i);

    }
}
