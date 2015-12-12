package ru.sbpstu.appmath.mamina.MyException;


public class CalculationException extends Exception {
    public CalculationException() {
        super("Calculation error!");
    }

    public CalculationException(String message) {
        super(message);
    }
}
