package ru.sbpstu.appmath.mamina.MyException;


public class SymbolException extends SyntaxException {
    public SymbolException() {
        super("Wrong symbol!");
    }
    public SymbolException(String message) {
        super(message);
    }
}


