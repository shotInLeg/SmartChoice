package com.shotinleg.smartchoice;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ResultScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        Intent intent = getIntent();
        final String[] texts = intent.getStringArrayExtra("result");
        int img = R.mipmap.ic_launcher;

        TextView text = (TextView)findViewById(R.id.textView2);

        if( texts.length > 0 )
        {
            text.setText("");
        }
        else
        {
            text.setText("Список пуст");
        }

        ListView listSet = (ListView)findViewById(R.id.listSet);


        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>(SetRestaurant.listSetRestaurant.size());
        Map<String, Object> m;
        for (int i = 0; i < SetRestaurant.listSetRestaurant.size(); i++)
        {
            m = new HashMap<String, Object>();
            m.put("text1", SetRestaurant.listSetRestaurant.get(i).getObjects().get(0).getName() );
            m.put("text2", SetRestaurant.listSetRestaurant.get(i).getCalories() );
            m.put("text3", SetRestaurant.listSetRestaurant.get(i).getPrice() );
            m.put("image", img);
            data.add(m);
        }

        String[] from = { "text3", "text2", "text1", "image" };
        int[] to = {R.id.tvPrice, R.id.tvCalories, R.id.tvName, R.id.ivImg };


        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);

        listSet.setAdapter(adapter);


        listSet.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id)
            {
                Intent intent = new Intent(ResultScreen.this, InfoScreen.class);
                intent.putExtra("id", String.valueOf( id ) );
                startActivity(intent);
            }
        });



       // ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catnames);

    }
}
