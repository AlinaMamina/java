package ru.sbpstu.appmath.mamina.exception;

public class ExpException extends Exception {
    public ExpException() {

        super("error!");
    }
    public ExpException(String message) {
        super(message);
    }
}
