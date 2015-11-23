package ru.spbstu.appmath.mamina;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.sbpstu.appmath.mamina.Expression;
import ru.sbpstu.appmath.mamina.Processing;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCalc {
    private String expression;
    private Double var;
    private Double answer;
    private String error;

    public TestCalc(String expression, Double var, Double answer, String error) {
        this.expression = expression;
        this.var = var;
        this.answer = answer;
        this.error = error;
    }

    private static final Object[][] TEST_DATA = new Object[][]{
            {"x", 0.0, 0.0, ""},
            {"1+x*x ", 2.0, 5.0, ""},
            {"x+(x-3)*5", 1.0, -9.0, ""},
            {"1/x - x +1.23 ", 2.0, -0.27, ""},
            {"19nan", 2.0, 302.14, "Syntax error!"},
            {"1 +1/0", 0.0, 0.0, "Calculation error!"},
            {"((2+2)", 0.0, 0.0, "Wrong count bracket!"}
    };

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    @Test
    public void test() {
        try {
            Assert.assertTrue("Wrong answer", checkResult());
        } catch (Exception e) {
            Assert.assertTrue("Wrong exception", checkException(e.getMessage()));
        }

    }

    private boolean checkResult() throws Exception {

        final Processing proc = new Processing();
        Expression result = proc.processStr(expression);
        if (result.calc(var) != answer)
            return false;
        else return true;
    }

    private boolean checkException(String exception) {
        System.out.print(exception);
        if (!exception.equals(error))
            return false;
        else return true;

    }


}

