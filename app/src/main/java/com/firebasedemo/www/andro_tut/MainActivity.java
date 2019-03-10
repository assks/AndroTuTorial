package com.firebasedemo.www.andro_tut;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bplay,babout,bexit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bplay =(Button) findViewById(R.id.play_button);
        babout =(Button) findViewById(R.id.about_button);
        bexit =(Button) findViewById(R.id.exit_button);
        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        bplay.setAnimation(slideUp);
        babout.setAnimation(slideUp);
        bexit.setAnimation(slideUp);

        bplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,MainClass.class);
                startActivity(i);

            }
        });
        babout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
                sharingIntent.setType("text/plain");
                //sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, download this app!");
               // sendIntent.putExtra(Intent.EXTRA_TEXT,
                 //       "Hey check out my app at: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                startActivity( Intent.createChooser(sharingIntent, "Share via"));

            }
        });
        bexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}
