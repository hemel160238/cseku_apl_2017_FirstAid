package com.example.helloworld.firstaid;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class Main2Activity extends AppCompatActivity {

    private static Button main4activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        String buttonName;
        buttonName = getIntent().getExtras().getString("bName");

    }
    public void onClick(View v) {
        Button b = (Button)v;
        String buttonText = b.getText().toString();

    }


}
