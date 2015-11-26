package com.shotinleg.smartchoice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ResultScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        Intent intent = getIntent();
        final String[] catnames = intent.getStringArrayExtra("result");

        TableLayout listView = (TableLayout)findViewById(R.id.tableView);
        for( int j = 0; j < 40; j++ )
        {
            TableRow row = new TableRow(this);
            for (int i = 0; i < 3; i++)
            {
                TextView text = new TextView(this);
                text.setText("Text: " + String.valueOf(i));

                row.addView(text);
            }
            listView.addView(row);
        }




       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catnames);

    }
}
