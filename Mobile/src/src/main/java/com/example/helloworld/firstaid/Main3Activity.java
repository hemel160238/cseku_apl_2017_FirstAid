package com.example.helloworld.firstaid;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Main3Activity extends AppCompatActivity {

    static int count3=0;

    JSONObject jsonObject;
    JSONArray jsonArray;
    ListView listView;
    Main3Activity.DoctorAdapter DoctorAdapter;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        s = getIntent().getExtras().getString("test");
        String t = getIntent().getExtras().getString("doctorlist");

        listView = (ListView) findViewById(R.id.list_doctor);
        DoctorAdapter = new Main3Activity.DoctorAdapter(this,R.layout.layout_doctor, s);
        listView.setAdapter(DoctorAdapter);
        try {
            jsonObject = new JSONObject(t);
            jsonArray = jsonObject.getJSONArray("doctor");

            int count = 0;
            String id, name,designation,phone;

            while (count < jsonArray.length()) {
                JSONObject jo = jsonArray.getJSONObject(count);
                id = jo.getString("id");
                name = jo.getString("name");
                designation = jo.getString("designation");
                phone = jo.getString("phone");

                doctor doctor = new doctor(id,name,designation,phone);

                DoctorAdapter.add(doctor);
                count++;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }





    }

    public class DoctorAdapter extends ArrayAdapter {

        List list = new ArrayList();
        Context ct;
        String fdoctor;

        public DoctorAdapter(@NonNull Context context, @LayoutRes int resource, String doctor) {
            super(context, resource);
            ct = context;
            this.fdoctor = doctor;
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
            count3++;


            View doctorview;

            doctorview = convertView;

            final doctorHolder doctorHolder;

            if (doctorview == null) {
                LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                doctorview = layoutInflater.inflate(R.layout.layout_doctor,parent,false);

                doctorHolder = new doctorHolder();

                doctorHolder.linearLayout2 = (LinearLayout) doctorview.findViewById(R.id.linearlayout2);
                doctorHolder.name = (TextView) doctorview.findViewById(R.id.textView7);
                doctorHolder.designation = (TextView) doctorview.findViewById(R.id.textView8);
                doctorHolder.phone = (TextView) doctorview.findViewById(R.id.textView6);

                doctorview.setTag(doctorHolder);
            } else {

                doctorHolder = (doctorHolder) doctorview.getTag();
            }

            final doctor doctor = (doctor) this.getItem(position);

            if((count3 % 2) == 0 )
            {
                //doctorHolder.linearLayout2
                doctorHolder.linearLayout2.setBackgroundColor(Color.parseColor("#ffffff"));//color should be changer
            }
            else
            {

                doctorHolder.linearLayout2.setBackgroundColor(Color.parseColor("#B3CEE2"));//color should be changer
            }



           ((TextView) doctorHolder.name).setText(doctor.getName());
            ((TextView) doctorHolder.designation).setText(doctor.getDesignation());
            ((TextView) doctorHolder.phone).setText((doctor.getPhone()));


            //buttonHolder.name.setText(newwbutton.getName());

            doctorview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String number = doctor.getPhone();

                    //String number = "7777777777";
                    Uri call = Uri.parse("tel:" + number);
                    Intent surf = new Intent(Intent.ACTION_DIAL, call);
                    startActivity(surf);

                    /*String number = "7777777777";
                    Uri call = Uri.parse("tel:" + number);
                    Intent surf = new Intent(Intent.ACTION_CALL, call);
                    startActivity(surf);*/


                }
            });
            return doctorview;
        }


    }

}
