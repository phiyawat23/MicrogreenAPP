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

public class Morningglory extends AppCompatActivity {
    Button back,btnlight,btnwater,btnfan,btnset;
    public FirebaseDatabase databasetext4,databasetext5,databasetext6,databasetext7,database4,database5,database6;
    public DatabaseReference datatemp2,datahumi2,datasoil2,light2,water2,fan2,grow2;
    TextView txttemp,txthumi,txtsoil,txtlight,txtwater,txtfan,txtgrow;
    Integer value,value_refer,value2,value_refer2,value3,value_refer3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morningglory);

        txttemp = (TextView)findViewById(R.id.txtTempmorn);
        txthumi = (TextView)findViewById(R.id.txtHumimorn);
        txtsoil = (TextView)findViewById(R.id.txtSoilmorn);
        txtlight = (TextView)findViewById(R.id.txtLight2);
        txtwater = (TextView)findViewById(R.id.txtWater2);
        txtfan = (TextView)findViewById(R.id.txtFan2);
        txtgrow = (TextView)findViewById(R.id.txtGrow2);
        btnlight = (Button)findViewById(R.id.btnLight2);
        btnwater = (Button)findViewById(R.id.btnWater2);
        btnfan = (Button)findViewById(R.id.btnFan2);
        btnset = (Button)findViewById(R.id.btnSet);
        btnset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent set = new Intent(Morningglory.this, morninggloryset.class);
                startActivity(set);
            }
        });

        databasetext4 = FirebaseDatabase.getInstance();
        datatemp2 = databasetext4.getReference("MorningGloryTemperature");

        datatemp2.addValueEventListener(new ValueEventListener() {
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

        databasetext5 = FirebaseDatabase.getInstance();
        datahumi2 = databasetext5.getReference("MorningGloryHumidity");
        datahumi2.addValueEventListener(new ValueEventListener() {
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

        databasetext6 = FirebaseDatabase.getInstance();
        datasoil2 = databasetext6.getReference("MorningGlorySoil");
        datasoil2.addValueEventListener(new ValueEventListener() {
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

        database4 = FirebaseDatabase.getInstance();
        light2 = database4.getReference("Light_Status/light_morning");
        light2.addValueEventListener(new ValueEventListener() {
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
                light2.setValue(value_refer);
            }
        });

        database5 = FirebaseDatabase.getInstance();
        water2 = database5.getReference("Light_Status/fog_morning");
        water2.addValueEventListener(new ValueEventListener() {
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
                water2.setValue(value_refer2);
            }
        });

        database6 = FirebaseDatabase.getInstance();
        fan2 = database6.getReference("Light_Status/fan_morning");
        fan2.addValueEventListener(new ValueEventListener() {
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
                fan2.setValue(value_refer3);
            }
        });

        back = (Button)findViewById(R.id.btnback2);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(Morningglory.this,MainActivity.class);
                startActivity(home);
            }
        });

        databasetext7 = FirebaseDatabase.getInstance();
        grow2 = databasetext4.getReference("MorningGloryGrowing");
        grow2.addValueEventListener(new ValueEventListener() {
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
