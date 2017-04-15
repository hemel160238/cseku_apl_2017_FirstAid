package com.example.helloworld.firstaid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Main4Activity extends AppCompatActivity {

    static int count2=1;
    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    MedicineAdapter MedicineAdapter;
    String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        TextView myView = (TextView) findViewById(R.id.textView4);
        s = getIntent().getExtras().getString("test");
        String t = getIntent().getExtras().getString("name");
        myView.setText(s);
        listView = (ListView) findViewById(R.id.listrog);
        MedicineAdapter = new MedicineAdapter(this, R.layout.layout_medicine, s);
        listView.setAdapter(MedicineAdapter);
        try {
            jsonObject = new JSONObject(t);
            jsonArray = jsonObject.getJSONArray("medicine");

            int count = 0;
            String id, symptom, medicine, provider;
            while (count < jsonArray.length()) {
                JSONObject jo = jsonArray.getJSONObject(count);
                id = jo.getString("id");
                symptom = jo.getString("symptom");
                medicine = jo.getString("medicine");
                provider = jo.getString("provider");
                medicines medicines = new medicines(id, symptom, medicine, provider);
                MedicineAdapter.add(medicines);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }




    public class MedicineAdapter extends ArrayAdapter {

        List list = new ArrayList();
        Context ct;
        String fmedicine;
        //int count2 = 0;

        public MedicineAdapter(@NonNull Context context, @LayoutRes int resource, String medicine) {
            super(context, resource);
            ct = context;
            this.fmedicine = medicine;
        }

        @Override
        public void add(@Nullable Object object) {
            super.add(object);
            list.add(object);
            //count2++;  //count is increasing;
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
            count2++;
            View medicineview,layoutview; //extra is layoutview
            medicineview = convertView;
            layoutview   = convertView;
            medicineHolder medicineHolder;
            if (medicineview == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                layoutview  = layoutInflater.inflate(R.layout.layout_medicine,parent,false);            //using layout
                medicineview = layoutInflater.inflate(R.layout.layout_medicine, parent, false);
                medicineHolder = new medicineHolder();


                medicineHolder.linearLayout = (LinearLayout) medicineview.findViewById(R.id.linearlayout); //adding layout
                medicineHolder.medicine = (TextView) medicineview.findViewById(R.id.textView3);
                medicineHolder.provider = (TextView) medicineview.findViewById(R.id.textView4);
                medicineview.setTag(medicineHolder);
            } else {
                medicineHolder = (medicineHolder) medicineview.getTag();
            }

            final medicines medicines = (medicines) this.getItem(position);
            //int medicineID = Integer.parseInt(medicines.getId());  // to get Medicine Id


            if((count2 % 2) == 0 )
            {
                medicineHolder.linearLayout.setBackgroundColor(Color.parseColor("#ffffff"));
            }
            else
            {
                medicineHolder.linearLayout.setBackgroundColor(Color.parseColor("#B3CEE2"));
            }


            medicineHolder.medicine.setText(medicines.getMedicine());
            medicineHolder.provider.setText(medicines.getProvider());
            medicineview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),medicines.getMedicine(), Toast.LENGTH_SHORT).show();
                }
            });
            return medicineview;
        }

    }
}

