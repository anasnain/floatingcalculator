package com.example.anas.samplecalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.floatingcalculator.FloatingCalculator;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FloatingCalculator floatingCalculator = new FloatingCalculator(MainActivity.this);
                floatingCalculator.showCalculator(v);
            }
        });
    }
}
