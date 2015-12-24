package ru.sbpstu.appmath.mamina.exception;


public class SyntaxException extends ExpException {
    public SyntaxException() {
        super("Wrong syntax!");
    }
    public SyntaxException(String message) {
        super(message);
    }
}
