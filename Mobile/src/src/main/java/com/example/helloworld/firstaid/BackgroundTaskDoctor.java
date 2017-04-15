package com.example.helloworld.firstaid;

import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Tanvir Hemel on 11-Apr-17.
 */

public class BackgroundTaskDoctor extends AsyncTask<String,Void,String>
{
    String JSON_string;
    String json_url;
    String button;

    @Override
    protected void onPreExecute() {
        json_url = "http://192.168.56.1/dreamwaver/getdoctors.php";
    }

    @Override
    protected String doInBackground(String... params) {
        button=params[0];
        try {
            URL url = new URL(json_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();

            while ((JSON_string = bufferedReader.readLine())!=null) {

                stringBuilder.append(JSON_string + "/n");
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

            return  stringBuilder.toString().trim();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {



    }
}