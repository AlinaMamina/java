package ru.sbpstu.appmath.mamina.MyException;


public class SyntaxException extends Exception {
    public SyntaxException() {
        super("Wrong syntax!");
    }
    public SyntaxException(String message) {
        super(message);
    }
}
