package com.shotinleg.smartchoice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class InfoScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        Intent intent = getIntent();
        final String number = intent.getStringExtra("number");

        TextView text = (TextView)findViewById(R.id.textView);
        text.setText(number);
    }
}
