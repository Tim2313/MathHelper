package org.example.service;

import org.example.model.Equation;

public class CounterService {

    private static CounterService instance;

    public int getNumbers(Equation equation) {

        int counter = 0;

        String newEquation = equation.getEquation();

        for (int i = 0, len = newEquation.length(); i < len; i++) {
            if (Character.isDigit(newEquation.charAt(i))) {
                counter++;
            }
        }

        return counter;
    }

    public static CounterService getInstance() {
        if (instance == null) {
            instance = new CounterService();
        }
        return instance;
    }
}
