package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText Bill;
    private SeekBar Percent;
    private Button Calculate;
    private TextView PercentText, Result, Tip;
    private int percentValue;
    private float billValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bill = (EditText) findViewById(R.id.bill);
        Percent = (SeekBar) findViewById(R.id.percent);
        Calculate = (Button) findViewById(R.id.calculate);
        PercentText = (TextView) findViewById(R.id.percentText);
        Result = (TextView) findViewById(R.id.result);
        Tip = (TextView)findViewById(R.id.tip);
        PercentText.setText(String.valueOf(Percent.getProgress())+"%");
        Calculate.setOnClickListener(this);
        Percent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PercentText.setText(String.valueOf(Percent.getProgress())+"%");
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
    public void onClick(View v){
        calculate();
    }
    public void calculate(){
        float res = 0.0f;
        if(!Bill.getText().toString().equals("")){
        billValue = Float.parseFloat(String.valueOf(Bill.getText()));
        res=billValue+Float.valueOf(percentValue*billValue/100);
        Tip.setText(String.valueOf(percentValue*billValue/100));
        Result.setText(String.valueOf(res));
    }
        else{
            Toast.makeText(MainActivity.this,"Molim unesite iznos racuna!",Toast.LENGTH_LONG).show();
        }
    }
}