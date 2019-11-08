package com.example.microgreenapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class sunflower extends AppCompatActivity {
    Button back,btnlight,btnwater,btnfan;
    public FirebaseDatabase databasetext,databasetext2,databasetext3,databasetext4,database1,database2,database3;
    public DatabaseReference datatemp,datahumi,datasoil,light,water,fan,grow;
    TextView txttemp,txthumi,txtsoil,txtlight,txtwater,txtfan,txtgrow;
    Integer value,value_refer,value2,value_refer2,value3,value_refer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sunflower);

        txttemp = (TextView)findViewById(R.id.txtTempsun);
        txthumi = (TextView)findViewById(R.id.txtHumisun);
        txtsoil = (TextView)findViewById(R.id.txtSoilsun);
        txtlight = (TextView)findViewById(R.id.txtLight);
        txtwater = (TextView)findViewById(R.id.txtWater);
        txtfan = (TextView)findViewById(R.id.txtFan);
        txtgrow = (TextView)findViewById(R.id.txtGrow);
        btnlight = (Button)findViewById(R.id.btnLight);
        btnwater = (Button)findViewById(R.id.btnWater);
        btnfan = (Button)findViewById(R.id.btnFan);


        databasetext = FirebaseDatabase.getInstance();
        datatemp = databasetext.getReference("SunflowerTemperature");
        datatemp.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                String temp = String.valueOf(map.get("Temperature"));
                txttemp.setText(temp);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databasetext2 = FirebaseDatabase.getInstance();
        datahumi = databasetext2.getReference("SunflowerHumidity");
        datahumi.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                String humi = String.valueOf(map.get("Humidity"));
                txthumi.setText(humi);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databasetext3 = FirebaseDatabase.getInstance();
        datasoil = databasetext3.getReference("SunflowerSoil");
        datasoil.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                String soil = String.valueOf(map.get("Soil"));
                txtsoil.setText(soil);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        database1 = FirebaseDatabase.getInstance();
        light = database1.getReference("Light_Status/light_sunflower");
        light.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value = dataSnapshot.getValue(Integer.class);
                if(value == 1){
                    txtlight.setText("ON");
                    btnlight.setBackgroundResource(R.drawable.lighton);
                    value_refer = 0;
                }
                else {
                    txtlight.setText("OFF");
                    btnlight.setBackgroundResource(R.drawable.lightoff);
                    value_refer = 1;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        btnlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                light.setValue(value_refer);
            }
        });

        database2 = FirebaseDatabase.getInstance();
        water = database2.getReference("Light_Status/fog_sunflower");
        water.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot2) {
            value2 = dataSnapshot2.getValue(Integer.class);
                if(value2 == 1){
                    txtwater.setText("ON");
                    btnwater.setBackgroundResource(R.drawable.wateron);
                    value_refer2 = 0;
                }
                else {
                    txtwater.setText("OFF");
                    btnwater.setBackgroundResource(R.drawable.wateroff);
                    value_refer2 = 1;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError2) {
            }
        });
        btnwater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                water.setValue(value_refer2);
            }
        });

        database3 = FirebaseDatabase.getInstance();
        fan = database3.getReference("Light_Status/fan_sunflower");
        fan.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot3) {
                value3 = dataSnapshot3.getValue(Integer.class);
                if(value3 == 1){
                    txtfan.setText("ON");
                    btnfan.setBackgroundResource(R.drawable.fanon);
                    value_refer3 = 0;
                }
                else {
                    txtfan.setText("OFF");
                    btnfan.setBackgroundResource(R.drawable.fanoff);
                    value_refer3 = 1;
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError3) {
            }
        });
        btnfan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fan.setValue(value_refer3);
            }
        });

        back = (Button)findViewById(R.id.btnback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(sunflower.this,MainActivity.class);
                startActivity(home);
            }
        });

        databasetext4 = FirebaseDatabase.getInstance();
        grow = databasetext4.getReference("SunflowerGrowing");
        grow.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Map map = (Map)dataSnapshot.getValue();
                String growing = String.valueOf(map.get("Growing"));
                txtgrow.setText(growing);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
