package com.example.floatingcalculator;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Anas on 22/10/17.
 */

public class FloatingCalculator extends View implements View.OnClickListener {
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
    private DecimalFormat decimalFormat = new DecimalFormat("#.##");
    private Double mResult = Double.NaN;

    private boolean resultSet = false;


    public FloatingCalculator(Context context) {
        this(context, null);
    }

    public FloatingCalculator(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        this.txtSolution = (TextView) popupViewLayout.findViewById(R.id.txtSolution);
        this.txtSolution.setText("");

        this.txtInput = (TextView) popupViewLayout.findViewById(R.id.txtInput);
        this.txtInput.setText("");
        this.txtInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String inputExp = s.toString();
                if (inputExp.length() > 1) {
                    char lastChar = inputExp.charAt(inputExp.length() - 1);
                    char prevLastChar = inputExp.charAt(inputExp.length() - 2);
                    if (Utility.isOperator(lastChar) && Utility.isOperator(prevLastChar)) {
                        inputExp = inputExp.substring(0, inputExp.length() - 2);
                        inputExp = inputExp.concat(String.valueOf(lastChar));
                        txtInput.setText(inputExp);
                    }
                    try {
                        List<Object> expList = Parser.getExpressionInList(inputExp);
                        if (expList.size() > 2) {
                            setResultInView(txtSolution);
                        }
                    } catch (Exception e) {
                        //ignore
                    }

                }
            }
        });

        this.btnZero = (Button) popupViewLayout.findViewById(R.id.btnZero);
        this.btnZero.setText("0");
        this.btnZero.setOnClickListener(this);

        this.btnOne = (Button) popupViewLayout.findViewById(R.id.btnOne);
        this.btnOne.setText("1");
        this.btnOne.setOnClickListener(this);

        this.btnTwo = (Button) popupViewLayout.findViewById(R.id.btnTwo);
        this.btnTwo.setText("2");
        this.btnTwo.setOnClickListener(this);

        this.btnThree = (Button) popupViewLayout.findViewById(R.id.btnThree);
        this.btnThree.setText("3");
        this.btnThree.setOnClickListener(this);

        this.btnFour = (Button) popupViewLayout.findViewById(R.id.btnFour);
        this.btnFour.setText("4");
        this.btnFour.setOnClickListener(this);

        this.btnFive = (Button) popupViewLayout.findViewById(R.id.btnFive);
        this.btnFive.setText("5");
        this.btnFive.setOnClickListener(this);

        this.btnSix = (Button) popupViewLayout.findViewById(R.id.btnSix);
        this.btnSix.setText("6");
        this.btnSix.setOnClickListener(this);

        this.btnSeven = (Button) popupViewLayout.findViewById(R.id.btnSeven);
        this.btnSeven.setText("7");
        this.btnSeven.setOnClickListener(this);

        this.btnEight = (Button) popupViewLayout.findViewById(R.id.btnEight);
        this.btnEight.setText("8");
        this.btnEight.setOnClickListener(this);

        this.btnNine = (Button) popupViewLayout.findViewById(R.id.btnNine);
        this.btnNine.setText("9");
        this.btnNine.setOnClickListener(this);

        this.btnDecimal = (Button) popupViewLayout.findViewById(R.id.btnDecimal);
        this.btnDecimal.setText(".");
        this.btnDecimal.setOnClickListener(this);

        this.btnAdd = (Button) popupViewLayout.findViewById(R.id.btnAdd);
        this.btnAdd.setText("+");
        this.btnAdd.setOnClickListener(this);

        this.btnSubtract = (Button) popupViewLayout.findViewById(R.id.btnSubtract);
        this.btnSubtract.setText("-");
        this.btnSubtract.setOnClickListener(this);

        this.btnMultiply = (Button) popupViewLayout.findViewById(R.id.btnMultiply);
        this.btnMultiply.setText("*");
        this.btnMultiply.setOnClickListener(this);

        this.btnDivide = (Button) popupViewLayout.findViewById(R.id.btnDivide);
        this.btnDivide.setText("/");
        this.btnDivide.setOnClickListener(this);

        this.btnEquals = (Button) popupViewLayout.findViewById(R.id.btnEquals);
        this.btnEquals.setText("=");
        this.btnEquals.setOnClickListener(this);

        this.btnClear = (Button) popupViewLayout.findViewById(R.id.btnClear);
        this.btnClear.setOnClickListener(this);

        this.btnBack = (Button) popupViewLayout.findViewById(R.id.btnBack);
        this.btnBack.setOnClickListener(this);
    }


    public void showCalculator(View view) {
        // show the popup window
        popupView.showAtLocation(view, Gravity.CENTER, 0, 0);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.btnBack) {
            try {
                String back = txtInput.getText().toString();
                int length = back.length() - 1;
                String back2 = back.substring(0, length);
                txtInput.setText(back2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == R.id.btnClear) {
            txtInput.setText("");
            txtSolution.setText("");
        } else if (i == R.id.btnEquals) {
            setResultInView(txtInput);
            txtSolution.setText("");
            resultSet = true;
        } else {
            String btnText = ((Button) v).getText().toString();
            if (resultSet && !Utility.isOperator(btnText))
                txtInput.setText(btnText);
            else
                txtInput.setText(txtInput.getText().toString().concat(btnText));
            resultSet = false;
        }
    }

    private double getResultFromExpression(String expression) {
        List<Object> expList = Parser.getExpressionInList(expression);
        if (expList.size() < 2)
            txtSolution.setText("");
        return ExpressionEvaluator.evaluateExpression(Parser.getExpressionInList(expression));
    }

    private void setResultInView(TextView txtOutputView) {
        Double result = getResultFromExpression(txtInput.getText().toString());
        txtOutputView.setText(decimalFormat.format(result));
        mResult = result;
    }

    public Double getResult() {
        return mResult;
    }
}
