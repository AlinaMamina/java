package ru.sbpstu.appmath.mamina.exception;


public class CalculationException extends ExpException {
    public CalculationException() {
        super("Calculation error!");
    }

    public CalculationException(String message) {
        super(message);
    }
}
