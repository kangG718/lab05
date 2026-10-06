package com.example.lab05calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.math.BigDecimal;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText first = findViewById(R.id.firstNumber);
        EditText second = findViewById(R.id.secondNumber);
        Spinner operation = findViewById(R.id.operation);
        TextView result = findViewById(R.id.resultText);
        Button calculate = findViewById(R.id.calculateButton);

        calculate.setOnClickListener((View view) -> {
            String firstText = first.getText().toString().trim();
            String secondText = second.getText().toString().trim();
            if (firstText.isEmpty() || secondText.isEmpty()) {
                result.setText(R.string.enter_both_numbers);
                return;
            }

            try {
                BigDecimal x = new BigDecimal(firstText);
                BigDecimal y = new BigDecimal(secondText);
                BigDecimal value = FourBasicOpt.calculate(
                        x, y, operation.getSelectedItemPosition());
                result.setText(value.stripTrailingZeros().toPlainString());
            } catch (NumberFormatException error) {
                result.setText(R.string.invalid_number);
            } catch (ArithmeticException error) {
                result.setText(R.string.divide_by_zero);
            }
        });
    }
}
