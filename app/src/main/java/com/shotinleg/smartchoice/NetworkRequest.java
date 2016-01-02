package com.shotinleg.smartchoice;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpRetryException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by shotinleg on 26.11.15.
 */
public class NetworkRequest
{
    private static String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for ( Map.Entry<String, String> entry : params.entrySet() )
        {
            if ( first )
            {
                first = false;
            }
            else
            {
                result.append("&"); //разделитель
            }

            result.append( URLEncoder.encode(entry.getKey(), "UTF-8") ); //ключ
            result.append("=");
            result.append( URLEncoder.encode(entry.getValue(), "UTF-8") ); //значение
        }

        return result.toString();
    }

    static public String GET( String requestURL, HashMap<String, String> postDataParams )
    {
        URL url;
        String response = "";

        try
        {
            url = new URL(requestURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(os, "UTF-8") );
            writer.write( getPostDataString( postDataParams ) );

            writer.flush();
            writer.close();
            os.close();
            int responseCode = conn.getResponseCode();

            if ( responseCode == HttpsURLConnection.HTTP_OK )
            {
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = br.readLine()) != null)
                {
                    response += line;
                }
            }
            else
            {
                response = "responseCode != HttpsURLConnection.HTTP_OK";
                return response;
                //throw new HttpRetryException(response, 0);
            }
        }
        catch (Exception e)
        {
            response = e.toString();
            e.printStackTrace();
        }

        return response;
    }

    static public ArrayList< SetRestaurant > parse( String answer )
    {
        ArrayList< SetRestaurant > result = new ArrayList<>();

        try
        {
            JSONObject json = new JSONObject( answer );
            String response = json.getString("response");
            JSONArray array = new JSONArray( response );

            for(int i = 0; i < array.length(); i++)
            {
                SetRestaurant tempSet = new SetRestaurant();


                String str = array.getString(i);
                json = new JSONObject(str);

                String price = json.getString("price");
                String calories = json.getString("calories");
                String obj = json.getString("objects");



                JSONArray objects = new JSONArray( obj );
                ArrayList< SetRestaurant.ObjectRestaurant > object = new ArrayList<>();
                for( int j = 0; j < objects.length(); j++ )
                {

                    String str2 = objects.getString(j);
                    JSONObject json2 = new JSONObject(str2);

                    int obj_id  = json2.getInt("id");
                    String obj_name = json2.getString("name");
                    String obj_price = json2.getString("price");
                    String obj_calories = json2.getString("calories");
                    String obj_type = json2.getString("type");

                    SetRestaurant.ObjectRestaurant tempObj = new SetRestaurant.ObjectRestaurant();
                    tempObj.setId(obj_id);
                    tempObj.setName( obj_name );
                    tempObj.setPrice(obj_price);
                    tempObj.setCalories(obj_calories);
                    tempObj.setType(obj_type);

                    object.add( tempObj );
                }

                tempSet.setPrice( price );
                tempSet.setCalories(calories);
                tempSet.setObjects( object );

                result.add( tempSet );
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        return result;
    }

}
