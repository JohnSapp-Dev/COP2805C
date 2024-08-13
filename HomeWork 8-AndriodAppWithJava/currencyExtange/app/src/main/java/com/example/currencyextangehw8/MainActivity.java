package com.example.currencyextangehw8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //RadioGroup currencyRDBtn;

    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

    public void buttonClick(View v){
        RadioButton radioBtnCAD = findViewById(R.id.radioBtnCAD);
        RadioButton radioBtnYEN = findViewById(R.id.radioBtnYEN);
        RadioButton radioBtnEUR = findViewById(R.id.radioBtnEUR);

        String selectedBtn = " ";
        String defaultExtange =" ";
        String inverseExtange = " ";
        if(radioBtnCAD.isChecked()){
            selectedBtn = radioBtnCAD.getText().toString();
            defaultExtange = "1.26";
            inverseExtange = "0.7937";

        }
        else if(radioBtnYEN.isChecked()){
            selectedBtn = radioBtnYEN.getText().toString();
            defaultExtange = "109.94";
            inverseExtange = "0.0091";
        }
        else if(radioBtnEUR.isChecked()){
            selectedBtn = radioBtnEUR.getText().toString();
            defaultExtange = "0.85";
            inverseExtange = "1.1765";
        }

        Intent newActivity = new Intent(this, MainActivity2.class);
        newActivity.putExtra("Currency Type",selectedBtn);
        newActivity.putExtra("Currency Rate",defaultExtange);
        newActivity.putExtra("Inverse Rate",inverseExtange);
        startActivity(newActivity);

    }

}