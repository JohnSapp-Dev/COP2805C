package com.example.currencyextangehw8;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String targetCurrencyTxt = getIntent().getStringExtra("Currency Type");
        String defaultRate = getIntent().getStringExtra("Currency Rate");
        // sets the text to the selected currency
        TextView txt = (TextView) findViewById(R.id.page2TextTarget);
        txt.setText(targetCurrencyTxt);
        //sets the selected currency to its default rate
        TextView txtRate = (TextView) findViewById(R.id.exchangeRateText);
        txtRate.setText(defaultRate);
        //sets convert button text to selected currency type
        TextView txtBtn = (TextView) findViewById(R.id.convertBtn);
        txtBtn.setText("Convert to "+targetCurrencyTxt);

    }

    public void convertFromUSD(View v){

        //Gets the text in the EditText box to set the amount of USD to exchange
        EditText USDText = (EditText) findViewById(R.id.USDExchangeRate);
        double USDValue = Double.parseDouble(USDText.getText().toString());

        //gets the currency exchange rate parses to double
        String defaultRate = getIntent().getStringExtra("Currency Rate");
        double rate = Double.parseDouble(defaultRate);

        //Gets the text value in the selected currency text box
        TextView txtRate = (TextView) findViewById(R.id.exchangeRateText);

        //preforms the exchange rate calculation and rounds to two decimals
        BigDecimal bd = new BigDecimal((USDValue * rate)).setScale(2, RoundingMode.HALF_UP);
        double roundedAnswer = bd.doubleValue();
        String answer = String.valueOf(roundedAnswer);
        txtRate.setText(answer);

    }

    public void convertToUSD(View v){
        //gets the text in the EditText box to set the amount of currency to exchange to USD
        EditText targetText = (EditText) findViewById(R.id.exchangeRateText);
        double targetValue = Double.parseDouble(targetText.getText().toString());

        //gets the currency exchange rate parses to double
        String defaultRate = getIntent().getStringExtra("Inverse Rate");
        double rate = Double.parseDouble(defaultRate);

        //Gets the text value in the selected currency text box
        TextView USDRate = (TextView) findViewById(R.id.USDExchangeRate);

        //preforms the exchange rate calculation and rounds to two decimals
        BigDecimal bd = new BigDecimal((rate * targetValue)).setScale(2, RoundingMode.HALF_UP);
        double roundedAnswer = bd.doubleValue();
        String answer = String.valueOf(roundedAnswer);
        USDRate.setText(answer);

    }

    public void returnClick(View v){
        finish();
    }
}