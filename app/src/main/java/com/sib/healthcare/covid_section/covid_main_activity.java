package com.sib.healthcare.covid_section;


import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import com.sib.healthcare.Activities.Consultancy.ConsFirstActivity;
import com.sib.healthcare.Activities.MainActivity;
import com.sib.healthcare.R;

public class covid_main_activity extends AppCompatActivity {

    ImageView flags;
    Spinner spinner;
    Button stat;
    Button call_nowBtn;
    ImageView call_nowCancleBtn;
    View remote_health_services;
    View back_to_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid_main);

        spinner = findViewById(R.id.spinner);
        flags = findViewById(R.id.flag);
        stat = findViewById(R.id.stat);
        call_nowBtn = findViewById(R.id.covid_main_activity_call_nowbtn);
        remote_health_services = findViewById(R.id.covid_activity_main_remote_health_services);
        back_to_home = findViewById(R.id.covid_main_activity_back_arraw);


        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
                CountryData.countryNames));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                flags.setImageResource(CountryData.countryFlag[spinner.getSelectedItemPosition()]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        stat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(covid_main_activity.this, Statistics.class);
                startActivity(i);

            }
        });

        call_nowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(covid_main_activity.this);
                dialog.setContentView(R.layout.main_activity_call_now);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
                dialog.show();
                dialog.setCanceledOnTouchOutside(false);

                call_nowCancleBtn = dialog.findViewById(R.id.call_nowCancleDialogBtn);

                call_nowCancleBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });


        remote_health_services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(covid_main_activity.this, ConsFirstActivity.class));
            }
        });

        back_to_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(covid_main_activity.this, MainActivity.class));
            }
        });

    }
}