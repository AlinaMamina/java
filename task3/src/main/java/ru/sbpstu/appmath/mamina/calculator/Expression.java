package ru.sbpstu.appmath.mamina.calculator;

import ru.sbpstu.appmath.mamina.exception.ExpException;

public interface Expression {
    Double calc(Double x) throws ExpException;
}
