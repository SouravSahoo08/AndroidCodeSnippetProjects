package com.example.appnumbershape;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public void check(View view) {
        String message;
        //Log.i("info", "button pressed");
        EditText editText = (EditText) findViewById(R.id.editText2);
        TextView result = (TextView) findViewById(R.id.result);
        if (editText.getText().toString().isEmpty()) {
            message = "pls enter a number";
        } else {
            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());
            message = editText.getText().toString();
            if (myNumber.isSquareNumber() && myNumber.isTriangularNumber()) {
                message += " is square and Triangular";
            } else if (myNumber.isSquareNumber()) {
                message += "is square ";
            } else if (myNumber.isTriangularNumber()) {
                message += " is Triangular";
            } else {
                message += " is neither square nor Triangular";
            }

        }
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        result.setText(message);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    static class Number {
        int number;

        boolean isSquareNumber() {
            double squareRoot = Math.sqrt(number);
            return squareRoot == Math.floor(squareRoot);   /*   if (squareRoot == Math.floor(squareRoot)) {
                                                                return true;
                                                                } else {
                                                                   return false;
                                                                     }       */
        }

        boolean isTriangularNumber() {
            int x = 1, triangularNumber = 1;

            while (triangularNumber < number) {
                x++;
                triangularNumber += x;
            }

            return triangularNumber == number;            /*  if (triangularNumber == number) {
                                                              return true;
                                                              } else {
                                                                    return false;
                                                                  }     */
        }
    }
}
