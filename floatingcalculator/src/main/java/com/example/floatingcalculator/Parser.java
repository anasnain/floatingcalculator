package com.example.floatingcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anas on 05/11/17.
 */

public class Parser {

    public static List<Object> getExpressionInList(String exp) {
        List<Object> expList = new ArrayList<>();
        String value = "";
        for (int i = 0; i < exp.length(); i++) {
            String input = String.valueOf(exp.charAt(i));
            if (Utility.isOperator(input)) {
                expList.add(Double.valueOf(value));
                expList.add(input);
                value = "";
            } else {
                value = value.concat(input);
            }
        }

        if (value != "" && value.length() > 0) {
            expList.add(Double.valueOf(value));
        }

        if((expList.get(expList.size()-1) instanceof String) &&
                Utility.isOperator((String) expList.get(expList.size()-1))) {
            expList.remove(expList.size()-1);
        }
        return expList;
    }
}
