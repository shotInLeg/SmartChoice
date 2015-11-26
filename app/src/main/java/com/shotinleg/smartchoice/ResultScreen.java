package com.shotinleg.smartchoice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
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
        for( int j = 0; j < catnames.length; j++ )
        {
            final int finalJ = j;

            TableRow row = new TableRow(this);
            row.setMinimumHeight(100);
            row.set
            row.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent  = new Intent(ResultScreen.this, InfoScreen.class);
                    intent.putExtra( "number", String.valueOf( finalJ ) );
                    startActivity(intent);
                }
            });

            ImageView col1 = new ImageView(this);
            TextView col2 = new TextView(this);
            TextView col3 = new TextView(this);
            TextView col4 = new TextView(this);

            col1.setMinimumWidth(100);
            col1.setMinimumHeight(100);
            col2.setText(catnames[j]);
            col3.setText("150ккал");
            col4.setText("200р");

            row.addView(col1);
            row.addView(col2);
            row.addView(col3);
            row.addView(col4);

            listView.addView(row);
        }




       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catnames);

    }
}
