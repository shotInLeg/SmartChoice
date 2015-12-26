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

        TextView text = (TextView)findViewById(R.id.textView2);

        if( catnames.length > 0 )
        {
            text.setText(catnames[0]);
        }
        else
        {
            text.setText("Список пуст");
        }

        ListView listSet = (ListView)findViewById(R.id.listSet);

        for( int j = 0; j < SetRestaurant.listSetRestaurant.size(); j++ )
        {
            final int finalJ = j;


            /*row.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    Intent intent  = new Intent(ResultScreen.this, InfoScreen.class);
                    intent.putExtra( "number", String.valueOf( finalJ ) );
                    startActivity(intent);
                }
            });*/



            //listSet.addView( SetRestaurant.listSetRestaurant.get(j).getObjects().get(0).getName() );
        }




       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catnames);

    }
}
