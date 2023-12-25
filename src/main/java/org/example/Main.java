package org.example;

import org.example.model.Equation;
import org.example.service.CounterService;
import org.example.service.EquationValidatorService;
import org.example.service.WriterService;

import java.util.Scanner;

public class Main {

    private static final EquationValidatorService EQUATION_VALIDATOR_SERVICE = EquationValidatorService.getInstance();
    private static final WriterService WRITER_SERVICE = WriterService.getInstance();

    private static final CounterService COUNTER_SERVICE = CounterService.getInstance();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Equation equation = new Equation();

        while (true) {
            System.out.println("Enter equation: ");
            equation.setEquation(scanner.nextLine());

            if (EQUATION_VALIDATOR_SERVICE.getValidateExpression(equation)) {
                WRITER_SERVICE.addEquation(equation);

                System.out.println("Equation has been added to the database!");

                String messageFormat = "In this equation are: %d numbers.";
                int countedNumbers = COUNTER_SERVICE.getNumbers(equation);

                String message = String.format(messageFormat, countedNumbers);

                System.out.println(message);
            } else {
                System.out.println("Invalid equation, try to write another.");
            }
        }
    }
}