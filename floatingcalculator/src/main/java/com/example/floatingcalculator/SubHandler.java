package com.example.floatingcalculator;

import android.widget.TextView;

public class SubHandler implements Handler {
    private double value1;
    private double value2;
    private double result;
    private String resultString;

    @Override
    public void handleIt(Object... parameters) {
        //declare Textviews from textViews pass from Calculator
        TextView inputTxt = (TextView) parameters[1];
        TextView solutionTxt = (TextView) parameters[2];

        value1 = Double.parseDouble(inputTxt.getText().toString());
        value2 = Double.parseDouble(solutionTxt.getText().toString());

        result = value2 - value1;

        resultString = Double.toString(result);

        solutionTxt.setText(resultString);

        inputTxt.setText("");
    }
}
