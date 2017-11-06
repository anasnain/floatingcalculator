package com.example.floatingcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Anas on 05/11/17.
 */

public class ExpressionEvaluator {

    /*Remove below method, kept for testing only*/
    public static void main(String[] args) {
        List<Object> objList = new ArrayList<>();
        objList.add(20.0);
        objList.add("-");
        objList.add(10.0);
        objList.add("*");
        objList.add(3.0);
        objList.add(10.0);

        Double expResult = evaluateExpression(objList);
        System.out.println("result : " + expResult);
    }

    public static Double evaluateExpression(List infixExp) {
        return evaluatePostfix(convertInfixToPostfix(infixExp));
    }

    private static List convertInfixToPostfix(List infixExp) {
        List postfixExpression = new ArrayList();
        /* Create stacks for operators and operands */
        Stack<String> operatorStack = new Stack<String>();
        operatorStack.push("(");
        infixExp.add(")");
        for (int i = 0; i < infixExp.size(); i++) {
            Object obj = infixExp.get(i);
            if (Utility.isOperand(obj)) {
                // ADD it to Postfix exp
                postfixExpression.add(obj);
            } else if (obj instanceof String && obj.equals("(")) {
                // Push it to stack
                operatorStack.push("(");
            } else if (obj instanceof String && Utility.isOperator((String) obj)) {
                // Repeatedly pop from stack and add to Postfix exp each operator which has same or higher precedence
                while (!operatorStack.empty()) {
                    String temp = operatorStack.peek();
                    if (Utility.isOperator(temp) && Utility.hasEqualOrHigherPrecedence((String) obj, temp)) {
                        postfixExpression.add(operatorStack.pop());
                    } else {
                        break;
                    }
                }
                // Push operator to stack
                operatorStack.push(String.valueOf(obj));
            } else if (obj instanceof String && obj.equals(")")) {
                // Repeatedly pop from stack and add to Postfix exp each operator until ( comes
                // Remove ( and do not add (
                while (!operatorStack.empty()) {
                    String top = operatorStack.pop();
                    if (!top.equals("(")) {
                        postfixExpression.add(top);
                    } else {
                        break;
                    }
                }
            }
        }
        return postfixExpression;
    }


    private static Double evaluatePostfix(List postfixExp) {
        /* Create stacks for operators and operands */
        Stack<Double> valueStack = new Stack<Double>();
        postfixExp.add(')');
        for (int i = 0; i < postfixExp.size(); i++) {
            Object obj = postfixExp.get(i);
            if (Utility.isOperand(obj)) {
                // Push to stack
                valueStack.push((double) obj);
            } else if (obj instanceof String && Utility.isOperator((String) obj)) {
                // Remove top two element from stack, A= top element B= next to top element
                // Evaluate operation B # A and place the result back to stack.
                if (!valueStack.empty() && valueStack.size() > 1) {
                    double A = valueStack.pop();
                    double B = valueStack.pop();
                    valueStack.push(evaluate((String) obj, B, A));
                }
            }
        }
        if (valueStack.size() == 1) {
            return valueStack.pop();
        }
        else throw new RuntimeException("Bad expression");
    }

    private static Double evaluate(String operator, double b, double a) {
        char op = operator.charAt(0);
        switch (op) {
            case '+':
                return b + a;
            case '-':
                return b - a;
            case '*':
                return b * a;
            case '/':
                return b / a;
            default:
                throw new IllegalArgumentException("Operator unknown: " + op);
        }
    }
}
