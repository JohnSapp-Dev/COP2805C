package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

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
        Button btn = (Button) v;
        btn.setText("Clicked!");

        TextView txt = findViewById(R.id.ExampleText);
        txt.setText("The button was clicked!");

        Intent newActivity = new Intent(this, SecondActivity.class);
        EditText userNameTxt = (EditText) findViewById(R.id.userName);
        newActivity.putExtra("User Name",userNameTxt.getText().toString());
        startActivity(newActivity);
    }
}