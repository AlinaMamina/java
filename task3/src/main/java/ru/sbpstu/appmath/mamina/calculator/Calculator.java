package ru.sbpstu.appmath.mamina.calculator;

import ru.sbpstu.appmath.mamina.exception.CalculationException;
import ru.sbpstu.appmath.mamina.exception.ExpException;

public class Calculator implements Expression {
    private final Expression left;
    private final Expression right;
    private final char operation;

    public Calculator(Expression left, Expression right, char operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public Double calc(Double x) throws ExpException {
        final Double resLeft = left.calc(x);
        final Double resRight = right.calc(x);
        switch (operation) {
            case '+':
                return (resLeft + resRight);
            case '-':
                return (resLeft - resRight);
            case '*':
                return (resLeft * resRight);
            case '/':
                if (resRight != 0)
                    return (resLeft / resRight);
                else
                    throw new CalculationException();
            default:
                return 0.0;
        }
    }
}

