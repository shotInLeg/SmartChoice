package com.shotinleg.smartchoice;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.HashMap;

import static com.shotinleg.smartchoice.NetworkRequest.GET;
import static com.shotinleg.smartchoice.NetworkRequest.parse;

public class MainScreen extends AppCompatActivity {
    private Intent intent;
    private TextView text;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onResultButtonClick(View view) {
        RequestTask requestTask = new RequestTask();
        intent = new Intent(this, ResultScreen.class);

        /*Intent intent = new Intent(this, Result.class);
        startActivity(intent);*/
        text = (TextView) findViewById(R.id.answer);

        EditText expenseObj = (EditText) findViewById(R.id.expense);
        String expense = expenseObj.getText().toString();

        EditText quantityObj = (EditText) findViewById(R.id.quantity);
        String quantity = quantityObj.getText().toString();

        EditText calories_fromObj = (EditText) findViewById(R.id.calories_from);
        String calories_from = calories_fromObj.getText().toString();

        EditText calories_toObj = (EditText) findViewById(R.id.calories_to);
        String calories_to = calories_toObj.getText().toString();

        requestTask.execute("http://praysnik.16mb.com/api/getListSet.php", "user_ids", quantity);

    }

    /*@Override
    public void onStart()
    {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction
        (
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainScreen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.shotinleg.smartchoice/http/host/path")
        );

        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "MainScreen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.shotinleg.smartchoice/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }*/

    class RequestTask extends AsyncTask<String, Integer, Void> {

        private String answer = "";

        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            text.setText("Start");
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
            for (Integer i = 1; i < cnt - 1; i += 2)
            {
                postDataParams.put(dataParams[i], dataParams[i + 1]);
            }

            answer = GET(requestURL, postDataParams);

            return null;
        }

        @Override
        protected void onPostExecute(Void result)
        {
            super.onPostExecute(result);

            ArrayList<SetRestaurant> res = parse(answer);
            String[] results = new String[res.size()];
            for (int i = 0; i < res.size(); i++)
            {
                results[i] = "";
                for (int j = 0; j < res.get(i).getObjects().size(); j++)
                {
                    results[i] = results[i] + res.get(i).getObjects().get(j).getName() + " ";
                }
            }

            //text.setText(answer);
            intent.putExtra("result", results );
            startActivity(intent);

        }
    }
}
