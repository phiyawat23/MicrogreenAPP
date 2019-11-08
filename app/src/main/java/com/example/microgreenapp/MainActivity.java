package com.example.microgreenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sunflowerbtn,morningbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sunflowerbtn = (Button)findViewById(R.id.btnSun);
        morningbtn = (Button)findViewById(R.id.btnmorning);

        sunflowerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sun = new Intent(MainActivity.this,sunflower.class);
                startActivity(sun);
            }
        });

        morningbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent morning = new Intent(MainActivity.this,Morningglory.class);
                startActivity(morning);
            }
        });


    }
}
