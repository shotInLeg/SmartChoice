package com.shotinleg.smartchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        ListView listView = (ListView) findViewById(R.id.listView);

        final String[] catnames = new String[]{
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте",
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте",
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте",
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте",
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте",
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте",
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте",
                "Биг Мак + Кола + Фри", "Биг Мак + Латте + Фри", "Биг Тейсти + Латте"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, catnames);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position, long id)
            {
                TextView textView = (TextView) itemClicked;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента

                Intent intent = new Intent(Result.this, FullView.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
