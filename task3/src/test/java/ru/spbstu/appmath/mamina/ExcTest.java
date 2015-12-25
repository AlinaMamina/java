package ru.spbstu.appmath.mamina;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.sbpstu.appmath.mamina.calculator.Expression;
import ru.sbpstu.appmath.mamina.calculator.Parser;
import ru.sbpstu.appmath.mamina.exception.BracketException;
import ru.sbpstu.appmath.mamina.exception.CalculationException;
import ru.sbpstu.appmath.mamina.exception.ExpException;
import ru.sbpstu.appmath.mamina.exception.SyntaxException;


public class ExcTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    String[] wrongData = {"a(_", "x+2/0", "((x)"};

    @Test
    public void testException() throws ExpException {
        expectedException.expect(SyntaxException.class);
        final Parser p = new Parser();
        p.parseStr(wrongData[0]);
    }

    @Test
    public void testException1() throws ExpException {
        expectedException.expect(CalculationException.class);
        final Parser p = new Parser();
        Expression f = p.parseStr(wrongData[1]);
        f.calc(1.0);
    }

    @Test
    public void testException2() throws ExpException {
        expectedException.expect(BracketException.class);
        final Parser p = new Parser();
        p.parseStr(wrongData[2]);
    }
}
