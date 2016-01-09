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

import static com.shotinleg.smartchoice.SetRestaurant.getIconFormId;
import static com.shotinleg.smartchoice.SetRestaurant.listSetRestaurant;

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



        int idNumber = Integer.parseInt(number);

        TextView prc = (TextView)findViewById( R.id.lPrice );
        TextView clrs = (TextView)findViewById( R.id.lCalories);

        prc.setText( listSetRestaurant.get(idNumber).getPrice()+"руб." );
        clrs.setText( listSetRestaurant.get(idNumber).getCalories()+"ккал" );

        ListView setComposition = (ListView)findViewById(R.id.setComposition);


        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>( listSetRestaurant.get(idNumber).getObjects().size() );
        Map<String, Object> m;
        for (int i = 0; i < listSetRestaurant.get(idNumber).getObjects().size(); i++)
        {
            m = new HashMap<String, Object>();

            m.put("Name", listSetRestaurant.get(idNumber).getObjects().get(i).getName() );
            m.put("Calories", listSetRestaurant.get(idNumber).getObjects().get(i).getCalories()+"ккал" );
            m.put("Price", listSetRestaurant.get(idNumber).getObjects().get(i).getPrice()+"руб." );
            m.put("Count", listSetRestaurant.get(idNumber).getObjects().get(i).getCount() );

            int img = getIconFormId( listSetRestaurant.get(idNumber).getObjects().get(i).getId() );

            m.put("Icon", img);
            data.add(m);
        }

        String[] from = { "Price", "Calories", "Count", "Name", "Icon" };
        int[] to = {R.id.tvLI1Price, R.id.tvLI1Calories, R.id.tvLI1Count, R.id.tvLI1Name, R.id.ivLI1Img };


        SimpleAdapter adapter = new SimpleAdapter(this, data, R.layout.list_item_1row, from, to);

        setComposition.setAdapter(adapter);
    }
}
