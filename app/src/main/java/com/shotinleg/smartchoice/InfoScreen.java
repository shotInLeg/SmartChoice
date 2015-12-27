package com.shotinleg.smartchoice;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InfoScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_screen);

        ImageView splash = (ImageView)findViewById( R.id.setSplash );
        splash.setImageBitmap(BitmapFactory.decodeResource(this.getResources(), R.mipmap.splash2));

        Intent intent = getIntent();
        final String number = intent.getStringExtra("id");

        TextView text = (TextView)findViewById(R.id.numberSet);
        text.setText("Набор номер: " + number);


        int idNumber = Integer.parseInt(number);

        TextView prc = (TextView)findViewById( R.id.lPrice );
        TextView clrs = (TextView)findViewById( R.id.lCalories);

        prc.setText( SetRestaurant.listSetRestaurant.get(idNumber).getPrice() );
        clrs.setText( SetRestaurant.listSetRestaurant.get(idNumber).getCalories() );

        ListView setComposition = (ListView)findViewById(R.id.setComposition);
        int img = R.mipmap.ic_launcher;

        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>( SetRestaurant.listSetRestaurant.get(idNumber).getObjects().size() );
        Map<String, Object> m;
        for (int i = 0; i < SetRestaurant.listSetRestaurant.get(idNumber).getObjects().size(); i++)
        {
            m = new HashMap<String, Object>();
            m.put("text1", SetRestaurant.listSetRestaurant.get(idNumber).getObjects().get(i).getName() );
            m.put("text2", SetRestaurant.listSetRestaurant.get(idNumber).getObjects().get(i).getCalories() );
            m.put("text3", SetRestaurant.listSetRestaurant.get(idNumber).getObjects().get(i).getPrice() );
            m.put("image", img);
            data.add(m);
        }

        String[] from = { "text3", "text2", "text1", "image" };
        int[] to = {R.id.tvPrice, R.id.tvCalories, R.id.tvName, R.id.ivImg };


        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item, from, to);

        setComposition.setAdapter(adapter);
    }
}
