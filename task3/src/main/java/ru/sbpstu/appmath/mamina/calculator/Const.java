package ru.sbpstu.appmath.mamina.calculator;


import ru.sbpstu.appmath.mamina.exception.ExpException;

public class Const implements Expression {
    private final Double value;

    public Const(Double value) {
        this.value = value;
    }

    public Double calc(Double x) throws ExpException {
        return this.value;
    }
}
