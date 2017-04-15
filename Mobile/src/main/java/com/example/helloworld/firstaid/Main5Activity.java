package com.example.helloworld.firstaid;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.button;

public class Main5Activity extends AppCompatActivity {


    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    Main5Activity.ButtonAdapter ButtonAdapter;
    String s;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



        s = getIntent().getExtras().getString("test");
        String t = getIntent().getExtras().getString("buttonlist");
        //TextView t1 = (TextView)findViewById(R.id.textView6);
        //t1.setText(t);


        //myView.setText(s);
        listView = (ListView) findViewById(R.id.list_button);
        ButtonAdapter = new Main5Activity.ButtonAdapter(this, R.layout.layout_newbuttons, s);
        listView.setAdapter(ButtonAdapter);
        try {
            jsonObject = new JSONObject(t);
            jsonArray = jsonObject.getJSONArray("symptomlist");

            int count = 0;
            //String id, symptom, medicine, provider;
            String naaam;
            while (count < jsonArray.length()) {
                JSONObject jo = jsonArray.getJSONObject(count);

                naaam  = jo.getString("symptom");

                newbuttons newbutton = new newbuttons(naaam);
                ButtonAdapter.add(newbutton);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }


public class ButtonAdapter extends ArrayAdapter{

    List list = new ArrayList();
    Context ct;
    String fbutton;

    public ButtonAdapter(@NonNull Context context, @LayoutRes int resource, String medicine) {
        super(context, resource);
        ct = context;
        this.fbutton = medicine;
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View buttonview;
        buttonview = convertView;
        buttonHolder buttonHolder;
        if (buttonview == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            buttonview = layoutInflater.inflate(R.layout.layout_newbuttons, parent, false);
            buttonHolder = new buttonHolder();

            buttonHolder.name = (TextView) buttonview.findViewById(R.id.textView5);
            buttonview.setTag(buttonHolder);
        } else {
            buttonHolder = (buttonHolder) buttonview.getTag();
        }
        final newbuttons newwbutton = (newbuttons) this.getItem(position) ;

        buttonHolder.name.setText(newwbutton.getName());
        buttonview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new BackgroundTask().execute(newwbutton.getName());

            }
        });
        return buttonview;
    }



}
    public class BackgroundTask extends AsyncTask<String,Void,String>
    {
        String JSON_string;
        String json_url;
        String button;

        @Override
        protected void onPreExecute() {

            //json_url = "http://192.168.56.1/dreamwaver/JSON.php";

            json_url = "http://192.168.15.207/dreamwaver/JSON.php";
        }

        @Override
        protected String doInBackground(String... params) {
            button=params[0];
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();

                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String postdata = URLEncoder.encode("medicine_id","UTF-8") + "=" +URLEncoder.encode(button,"UTF-8");
                bufferedWriter.write(postdata);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

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

            Intent intent = new Intent(Main5Activity.this,Main4Activity.class);
            intent.putExtra("test",button);
            intent.putExtra("name",result);
            startActivity(intent);

        }
    }



    public  class newbuttons{
        String name;

       public newbuttons(String newbuttonname)
       {
           this.name = newbuttonname;
       }

        public String getName() {
            return name;
        }
    }



}

