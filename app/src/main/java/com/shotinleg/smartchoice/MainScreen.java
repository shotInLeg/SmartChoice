package com.shotinleg.smartchoice;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import static com.shotinleg.smartchoice.NetworkRequest.GET;


public class MainScreen extends AppCompatActivity {

    RequestTask requestTask;
    TextView text;
    String answer;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_screen, menu);
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



    public void onResultButtonClick(View view)
    {
        text = (TextView)findViewById(R.id.answer);
        requestTask = new RequestTask();
        intent = new Intent(this, Result.class);

        /*Intent intent = new Intent(this, Result.class);
        startActivity(intent);*/

        EditText expenseObj = (EditText)findViewById(R.id.expense);
        Editable expense = expenseObj.getText();

        EditText quantityObj = (EditText)findViewById(R.id.quantity);
        Editable quantity = quantityObj.getText();

        requestTask.execute("https://api.vk.com/method/users.get", "user_ids", quantity.toString());

        EditText calories_fromObj = (EditText)findViewById(R.id.calories_from);
        Editable calories_from = calories_fromObj.getText();

        EditText calories_toObj = (EditText)findViewById(R.id.calories_to);
        Editable calories_to = calories_toObj.getText();


    }

    class RequestTask extends AsyncTask<String, Integer, Void>
    {

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            text.setText("Begin");
        }

        @Override
        protected Void doInBackground(String... params)
        {
            int cnt = 0;
            String[] dataParams = new String[50];

            for (String param : params)
            {
                dataParams[cnt] = param;
                publishProgress(++cnt);
            }

            String requestURL = dataParams[0];
            HashMap<String, String> postDataParams = new HashMap<String, String>();
            for(Integer i = 1; i < cnt-1; i += 2)
            {
                postDataParams.put(dataParams[i], dataParams[i+1]);
            }

            answer = GET(requestURL, postDataParams);

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);
            intent.putExtra("answer", answer);
            startActivity(intent);

        }
    }
}
