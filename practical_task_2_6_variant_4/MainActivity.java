package com.example.practical_task_2_6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editTextFirst = findViewById(R.id.etDuration);
        EditText editTextSecond = findViewById(R.id.etPersent);
        EditText editTextThird = findViewById(R.id.etStartSum);
        TextView textViewInfo = findViewById(R.id.tvInfo);
        TextView textViewResult = findViewById(R.id.tvResult);
        TextView textViewResultSum = findViewById(R.id.tvResultSum);
        TextView textViewResultMonth = findViewById(R.id.tvResultMonth);
        TextView textViewResultSumMonth = findViewById(R.id.tvResultSumMonth);
        TextView textViewPersonalDataName = findViewById(R.id.tvPersonalDataName);
        TextView textViewPersonalDataGroup = findViewById(R.id.tvPersonalDataGroup);
        Button btnSum = findViewById(R.id.btnSum);
        btnSum.setOnClickListener(v -> {
            Log.i("simple_app_tag", "Click start button");
            String firstTermStr = editTextFirst.getText().toString();
            String secondTermStr = editTextSecond.getText().toString();
            String thirdTermStr = editTextThird.getText().toString();
            if (!firstTermStr.isEmpty() && !secondTermStr.isEmpty() && !thirdTermStr.isEmpty()) {
                int duration = Integer.parseInt(firstTermStr);
                int percent = Integer.parseInt(secondTermStr);
                int startSum = Integer.parseInt(thirdTermStr);
                float coefficient = (float) (percent);
                coefficient = 1 + coefficient/100;
                int i = 0;
                float currentSum = (float) startSum;
                String allCurrentSumsStr = "";
                while (i < duration) {
                    currentSum = currentSum * coefficient;
                    allCurrentSumsStr = allCurrentSumsStr + String.valueOf(currentSum) + "\n";
                    i += 1;
                }
                Log.i("simple_app_tag", "Result calculation: " + currentSum);
                textViewResultSum.setText(String.valueOf(currentSum));
                textViewResultSumMonth.setText(String.valueOf(allCurrentSumsStr));
            } else {
                Log.w("simple_app_tag", "Empty term");
                Toast.makeText(getApplicationContext(), "Invalid terms", Toast.LENGTH_LONG).show();
            }
        });
    }
}
