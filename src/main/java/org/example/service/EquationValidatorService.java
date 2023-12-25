package org.example.service;

import org.example.model.Equation;

public class EquationValidatorService {

    private static EquationValidatorService instance;

    public boolean getValidateByDublicates(Equation equation) {

        String newEquation = equation.getEquation();

        if (newEquation.contains("-*") ||
                newEquation.contains("+*") ||
                newEquation.contains("-/") ||
                newEquation.contains("+/") ||
                newEquation.contains("--") ||
                newEquation.contains("//") ||
                newEquation.contains("**") ||
                newEquation.contains("++")) {
            return true;
        }

        return false;
    }

    public boolean getValidateByBrackets(Equation equation) {

        String newEquation = equation.getEquation();


        int openBrackets = 0;

        for (char i : newEquation.toCharArray()) {
            if (i == '(') {
                openBrackets++;
            }
            if (i == ')') {
                openBrackets--;
            }
        }

        if (openBrackets == 0) {
            return true;
        }

        return false;
    }

    public boolean getValidateExpression(Equation equation) {

        if (getValidateByDublicates(equation)) {
            return false;
        }

        if (!getValidateByBrackets(equation)) {
            return false;
        }

        return true;
    }

    public static EquationValidatorService getInstance() {
        if (instance == null) {
            instance = new EquationValidatorService();
        }
        return instance;
    }

}
