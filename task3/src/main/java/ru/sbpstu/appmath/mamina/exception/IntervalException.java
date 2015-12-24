package ru.sbpstu.appmath.mamina.exception;


public class IntervalException extends SyntaxException {
    public IntervalException () {
        super("Problem with interval!");
    }
    public IntervalException (String message) {
        super(message);
    }
}
