package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText=(EditText) findViewById(R.id.editText);
    EditText result=(EditText) findViewById(R.id.result);
    public void convert(View view){

        String amountDollarsString =editText.getText().toString();
        double amountDollarsDouble= Double.parseDouble(amountDollarsString);
        double amountRupeesDouble= amountDollarsDouble * 74.88;
        String  amountRupeesString=String.format("%.2f", amountRupeesDouble) ;
        result.setText(amountRupeesString);
       // Toast.makeText(this, "$" + amountDollarsString +" = Rs" + amountRupeesString, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button resetButton = (Button) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the first EditText empty
                editText.setText("");

                // Clear the second EditText
                result.getText().clear();
            }
        });
    }
}
