package ru.appmath.mamina.exception;

/**
 * Created by 123 on 24.12.2015.
 */
public class SizeException extends MatrixCalcException {
    public SizeException() {
        super("File doesn't contain valid data");
    }
}
