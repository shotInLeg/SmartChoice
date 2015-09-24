package com.shotinleg.smartchoice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.HashMap;


import static com.shotinleg.smartchoice.NetworkRequest.GET;


public class MainScreen extends AppCompatActivity {

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
        /*Intent intent = new Intent(this, Result.class);
        startActivity(intent);*/

        EditText expenseObj = (EditText)findViewById(R.id.expense);
        Editable expense = expenseObj.getText();

        EditText quantityObj = (EditText)findViewById(R.id.quantity);
        Editable quantity = quantityObj.getText();

        EditText calories_fromObj = (EditText)findViewById(R.id.calories_from);
        Editable calories_from = calories_fromObj.getText();

        EditText calories_toObj = (EditText)findViewById(R.id.calories_to);
        Editable calories_to = calories_toObj.getText();

        String requestURL = "http://knowledge.globaltape.ru/api/smartchoice/getOptimalItems";
        requestURL = "https://api.vk.com/method/users.get?fields=photo_100";
        HashMap<String, String> postDataParams = new HashMap<String, String>();
        postDataParams.put("user_ids", "1" );
       /* postDataParams.put("restaurant", "mcdonalds" );
        postDataParams.put("expense", expense.toString() );
        postDataParams.put("quantity", quantity.toString() );
        postDataParams.put("calories_from", calories_from.toString() );
        postDataParams.put("calories_to", calories_to.toString() );*/

        String answer = GET(requestURL, postDataParams);

        TextView text = (TextView)findViewById(R.id.answer);
        text.setText(answer );

    }
}
