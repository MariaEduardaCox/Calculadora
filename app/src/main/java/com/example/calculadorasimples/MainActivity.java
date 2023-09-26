package com.example.calculadorasimples;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText num1EditText, num2EditText, resultEditText;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializar as views
        num1EditText = findViewById(R.id.num1EditText);
        num2EditText = findViewById(R.id.num2EditText);
        resultEditText = findViewById(R.id.resultEditText);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("x");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("÷");
            }
        });
    }

    private void calculate(String operator) {
        String num1Str = num1EditText.getText().toString();
        String num2Str = num2EditText.getText().toString();

        if (!num1Str.isEmpty() && !num2Str.isEmpty()) {
            double num1 = Double.parseDouble(num1Str);
            double num2 = Double.parseDouble(num2Str);
            double result = 0;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "x":
                    result = num1 * num2;
                    break;
                case "÷":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        resultEditText.setText("Erro");
                        return;
                    }
                    break;
            }


            resultEditText.setText(String.valueOf(result));
        }
    }
}