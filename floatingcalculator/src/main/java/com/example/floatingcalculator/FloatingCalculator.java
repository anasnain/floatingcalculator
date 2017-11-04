package com.example.floatingcalculator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/**
 * Created by Anas on 22/10/17.
 */

public class FloatingCalculator extends View {
    private PopupWindow popupView;
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnDecimal;
    private Button btnEquals;

    private Button btnClear;
    private Button btnBack;

    private TextView txtInput;
    private TextView txtSolution;

    private Context context;
    protected String command;
    protected String opperand;
    protected String numKey;
    protected String btnNumber;
    protected int counter;

    public FloatingCalculator(Context context) {
        this(context, null);
    }

    public FloatingCalculator(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        //TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.DashProgressIndicator, 0, 0);
        //mStepCount = a.getInt(R.styleable.DashProgressIndicator_totalCount, 1);
        //mCurrentStep = a.getInt(R.styleable.DashProgressIndicator_currentCount, 1);
        //a.recycle();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupViewLayout = inflater.inflate(R.layout.layout_popup, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        //boolean focusable = true; // lets taps outside the popup also dismiss it
        //popupView = new PopupWindow(popupView, width, height, focusable);
        popupView = new PopupWindow(popupViewLayout, width, height);

        // dismiss the popup window when touched
        popupViewLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                FloatingCalculator.this.popupView.dismiss();
                return true;
            }
        });

        setUpViews(popupViewLayout);
    }

    private void setUpViews(View popupViewLayout) {
        this.txtInput = (TextView) popupViewLayout.findViewById(R.id.txtInput);
        this.txtSolution = (TextView) popupViewLayout.findViewById(R.id.txtSolution);

        command = "=";
        opperand = "";
        numKey = "numKey";

        this.btnZero = (Button) popupViewLayout.findViewById(R.id.btnZero);
        this.btnZero.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnZero.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);

            }
        });

        this.btnOne = (Button) popupViewLayout.findViewById(R.id.btnOne);
        this.btnOne.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                btnNumber = btnOne.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnTwo = (Button) popupViewLayout.findViewById(R.id.btnTwo);
        this.btnTwo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnTwo.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnThree = (Button) popupViewLayout.findViewById(R.id.btnThree);
        this.btnThree.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnThree.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnFour = (Button) popupViewLayout.findViewById(R.id.btnFour);
        this.btnFour.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnFour.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnFive = (Button) popupViewLayout.findViewById(R.id.btnFive);
        this.btnFive.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnFive.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnSix = (Button) popupViewLayout.findViewById(R.id.btnSix);
        this.btnSix.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnSix.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnSeven = (Button) popupViewLayout.findViewById(R.id.btnSeven);
        this.btnSeven.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnSeven.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnEight = (Button) popupViewLayout.findViewById(R.id.btnEight);
        this.btnEight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnEight.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnNine = (Button) popupViewLayout.findViewById(R.id.btnNine);
        this.btnNine.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                btnNumber = btnNine.getText().toString();
                ApplicationController.handleRequest(numKey, btnNumber, txtInput);
            }
        });

        this.btnDecimal = (Button) popupViewLayout.findViewById(R.id.btnDecimal);
        this.btnDecimal.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String InputText = txtInput.getText().toString();
                counter = InputText.indexOf(".");

                if(counter == -1){

                    btnNumber = btnDecimal.getText().toString();
                    ApplicationController.handleRequest(numKey, btnNumber, txtInput);
                }

            }
        });

        this.btnSubtract = (Button) popupViewLayout.findViewById(R.id.btnSubtract);
        this.btnSubtract.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                opperand = btnSubtract.getText().toString();
                ApplicationController.handleRequest(command, txtInput, txtSolution);
                command = opperand;
            }
        });

        this.btnMultiply = (Button) popupViewLayout.findViewById(R.id.btnMultiply);
        this.btnMultiply.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                opperand = btnMultiply.getText().toString();
                ApplicationController.handleRequest(command, txtInput, txtSolution);
                command = opperand;
            }
        });

        this.btnDivide = (Button) popupViewLayout.findViewById(R.id.btnDivide);
        this.btnDivide.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                opperand = btnDivide.getText().toString();
                ApplicationController.handleRequest(command, txtInput, txtSolution);
                command = opperand;
            }
        });

        this.btnAdd = (Button) popupViewLayout.findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                opperand = btnAdd.getText().toString();
                ApplicationController.handleRequest(command, txtInput, txtSolution);
                command = opperand;
            }
        });

        this.btnEquals = (Button) popupViewLayout.findViewById(R.id.btnEquals);
        this.btnEquals.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                opperand = btnEquals.getText().toString();
                ApplicationController.handleRequest(command, txtInput, txtSolution);
                //pass command and a list of parameters(Object ... params)
                command = opperand;
            }
        });


        this.btnClear = (Button) popupViewLayout.findViewById(R.id.btnClear);
        this.btnClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                txtInput.setText("");
                txtSolution.setText("");
                command = "=";
                opperand = "=";
            }
        });


        this.btnBack = (Button) popupViewLayout.findViewById(R.id.btnBack);
        this.btnBack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    String back = txtInput.getText().toString();
                    int length = back.length() - 1;
                    String back2 = back.substring(0, length);
                    txtInput.setText(back2);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void showCalculator(View view) {
        // show the popup window
        popupView.showAtLocation(view, Gravity.CENTER, 0, 0);
    }
}
