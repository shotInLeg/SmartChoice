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

import static com.shotinleg.smartchoice.SetRestaurant.getIconFormId;
import static com.shotinleg.smartchoice.SetRestaurant.listSetRestaurant;

public class ResultScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        TextView tvInfo = (TextView)findViewById(R.id.tvInfo);
        ListView listSet = (ListView)findViewById(R.id.listSet);

        if( listSetRestaurant.size() > 0 )
            tvInfo.setText("");
        else
            tvInfo.setText("Список пуст");


        ArrayList<Map<String, Object>> data = new ArrayList<Map<String, Object>>( listSetRestaurant.size() );
        Map<String, Object> m;
        for (int i = 0; i < listSetRestaurant.size(); i++)
        {
            m = new HashMap<String, Object>();

            m.put("Name", listSetRestaurant.get(i).getObjects().get(0).getName() );

            String subname = "";
            if( listSetRestaurant.get(i).getObjects().size() > 1 )
            {
                for (int j = 1; j < listSetRestaurant.get(i).getObjects().size(); j++) {
                    subname += listSetRestaurant.get(i).getObjects().get(j).getName();
                    subname += ", ";
                }
            }


            m.put("SubName", subname );
            m.put("Price", "Р: "+listSetRestaurant.get(i).getPrice() );
            m.put("Calories", "К: "+listSetRestaurant.get(i).getCalories() );


            int img = getIconFormId( listSetRestaurant.get(i).getObjects().get(0).getId() );

            m.put("Icon", img);
            data.add(m);
        }

        String[] from = { "Price", "Calories", "Name", "SubName", "Icon" };
        int[] to = {R.id.tvPrice, R.id.tvCalories, R.id.tvName, R.id.tvSubName, R.id.ivImg };


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
