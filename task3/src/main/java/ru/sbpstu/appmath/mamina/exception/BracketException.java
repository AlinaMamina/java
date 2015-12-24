package ru.sbpstu.appmath.mamina.exception;


public class BracketException extends SyntaxException {
    public BracketException() {
        super("Wrong count bracket!");
    }

    public BracketException(String message) {
        super(message);
    }
}

