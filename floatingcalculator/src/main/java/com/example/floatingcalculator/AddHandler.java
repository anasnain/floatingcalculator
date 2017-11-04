package com.example.floatingcalculator;

import android.widget.TextView;

public class AddHandler implements Handler {
	private double value1;
	private double value2;
	private double result;
	private String resultString;
	
	@Override
	public void handleIt(Object ... parameters) {
		//declare Textviews from textViews pass from Calculator
		TextView txtInput = (TextView) parameters[0];
		TextView txtSolution = (TextView) parameters[1];

		value1 = Double.parseDouble(txtInput.getText().toString());
		value2 = Double.parseDouble(txtSolution.getText().toString());
		
		result = value1 + value2;
		
		resultString = Double.toString(result);
		
		txtSolution.setText(resultString);			
	 
		txtInput.setText("");
	}
}
