package com.example.floatingcalculator;

/**
 * Created by Anas on 05/11/17.
 */

public class Utility {

    public static boolean isOperand(Object operand) {
        return operand instanceof Number;
    }

    public static boolean isOperator(String operator) {
        Character ch = operator.charAt(0);
        return isOperator(ch);
    }

    public static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/') ? true : false;
    }

    public static boolean hasEqualOrHigherPrecedence(String operatorEncountered, String operatorFromStack) {
        return precedenceLevel(operatorFromStack) >= precedenceLevel(operatorEncountered) ? true : false;
    }

    public static int precedenceLevel(String operator) {
        char ch = operator.charAt(0);
        switch (ch) {
            case '+':
            case '-':
                return 0;
            case '*':
            case '/':
                return 1;
            case '^':
                return 2;
            default:
                throw new IllegalArgumentException("Operator unknown: " + operator);
        }
    }
}
