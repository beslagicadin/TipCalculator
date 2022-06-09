package com.example.tipcalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText Bill;
    private SeekBar Percent;
    private TextView PercentText, Result, Tip;
    private int percentValue;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bill = (EditText) findViewById(R.id.bill);
        Percent = (SeekBar) findViewById(R.id.percent);
        Button calculate = (Button) findViewById(R.id.calculate);
        PercentText = (TextView) findViewById(R.id.percentText);
        Result = (TextView) findViewById(R.id.result);
        Tip = (TextView) findViewById(R.id.tip);
        PercentText.setText(Percent.getProgress() + "%");
        calculate.setOnClickListener(this);
        Percent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PercentText.setText(Percent.getProgress() + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                percentValue = Percent.getProgress();
            }
        });
    }
    @Override
    public void onClick(View v) {
        calculate();
    }
    public void calculate() {
        if (Bill.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, R.string.billValueEmptyWarning, Toast.LENGTH_SHORT).show();
        } else {
            float billValue = Float.parseFloat(String.valueOf(Bill.getText()));
            float res = billValue + percentValue * billValue / 100;
            Tip.setText(String.valueOf(percentValue * billValue / 100));
            Result.setText(String.valueOf(res));
        }
    }
}