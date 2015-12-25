package ru.sbpstu.appmath.mamina.calculator;


import ru.sbpstu.appmath.mamina.exception.CalculationException;

public class Const implements Expression {
    private final Double value;

    public Const(Double value) {
        this.value = value;
    }

    public Double calc(Double x) throws CalculationException {
        return this.value;
    }
}
