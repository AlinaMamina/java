package ru.sbpstu.appmath.mamina.MyException;


public class ColonException extends SyntaxException {
    public ColonException () {
        super("Problem with colon!");
    }
    public ColonException (String message) {
        super(message);
    }
}
