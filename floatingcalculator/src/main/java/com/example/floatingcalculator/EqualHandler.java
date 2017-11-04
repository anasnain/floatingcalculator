package com.example.floatingcalculator;

import android.widget.TextView;

public class EqualHandler implements Handler {

    @Override
    public void handleIt(Object... parameters) {
        //declare Textviews from textViews pass from Calculator
        TextView inputTxt = (TextView) parameters[0];
        TextView solutionTxt = (TextView) parameters[1];

        solutionTxt.setText(inputTxt.getText().toString());
        inputTxt.setText("");
    }
}