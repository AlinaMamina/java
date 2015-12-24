package ru.sbpstu.appmath.mamina.exception;


public class SymbolException extends SyntaxException {
    public SymbolException() {
        super("Wrong symbol!");
    }
    public SymbolException(String message) {
        super(message);
    }
}


