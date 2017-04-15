package com.example.helloworld.firstaid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    private static Button b_symptoms, b_emergency, b_about;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickListener_symptom();
        OnClickListener_emergency();
        OnClickListener_about();

    }

    public void OnClickListener_about() {
        b_about = (Button) findViewById(R.id.button_about);


        b_about.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //TextView t1 = (TextView)findViewById(R.id.textView9) ;
                        //t1.setText("Hello World");

                        Intent intent = new Intent(MainActivity.this,Main7Activity.class);
                        startActivity(intent);



                    }
                }

        );


    }


    public void OnClickListener_symptom() {
        b_symptoms = (Button) findViewById(R.id.button_symptoms);

        b_symptoms.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        new BackgroundTask1().execute("Hello");
                    }
                }
        );


    }

    public void OnClickListener_emergency() {
        b_emergency = (Button) findViewById(R.id.button_emergency);

        b_emergency.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new BackgroundTaskDoctor().execute("start");
                    }
                }
        );

    }

    public class BackgroundTask1 extends AsyncTask<String,Void,String>
    {
        String JSON_string;
        String json_url;
        String button;

        @Override
        protected void onPreExecute() {
            //json_url = "http://192.168.56.1/dreamwaver/getsymptoms.php";
              json_url = "http://192.168.15.207/dreamwaver/getsymptoms.php";


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

            Intent intent = new Intent(MainActivity.this,Main5Activity.class);
            intent.putExtra("test",button);
            intent.putExtra("buttonlist",result);
            startActivity(intent);

        }
    }



    public class BackgroundTaskDoctor extends AsyncTask<String,Void,String>
    {
        String JSON_string;
        String json_url;
        String button;

        @Override
        protected void onPreExecute() {
            //json_url = "http://192.168.56.1/dreamwaver/getdoctors.php";

            json_url = "http://192.168.15.207/dreamwaver/getdoctors.php";
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

            Intent intent = new Intent(MainActivity.this,Main3Activity.class);
            intent.putExtra("test",button);
            intent.putExtra("doctorlist",result);
            startActivity(intent);

        }
    }
}
