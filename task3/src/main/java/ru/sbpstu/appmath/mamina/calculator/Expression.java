package ru.sbpstu.appmath.mamina.calculator;


import ru.sbpstu.appmath.mamina.exception.CalculationException;

public interface Expression {
    Double calc(Double x) throws CalculationException;
}
