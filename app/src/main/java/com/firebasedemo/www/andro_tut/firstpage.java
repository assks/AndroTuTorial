package com.firebasedemo.www.andro_tut;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class firstpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_firstpage );

    }

    public void info(View view) {
    startActivity( new Intent( getApplicationContext(),MainActivity.class ) );
    }
}
