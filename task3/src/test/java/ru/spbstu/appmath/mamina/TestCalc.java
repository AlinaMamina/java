package ru.spbstu.appmath.mamina;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestCalc{
    private String expression;
    private Double var;
    private Double result;
    private String error;

    public TestCalc(String expression, Double var, Double result, String error) {
        this.expression = expression;
        this.var = var;
        this.result = result;
        this.error = error;
    }
    private static final Object[][] TEST_DATA = new Object[][]{
            {"x",0.0,0.0,""},
            {"1+x*x ",2.0, 5.0,""},
            {"x+(x-3)*5",1.0,-9.0,""},
            {"1/x - x +1.23 ",2.0, -0.27,""},
            {"19nan",2.0,302.14,"Wrong symbols in expression"},
            {"1 +1/0",0.0,0.0,"Division by zero"},
            {"((2+2)",0.0,0.0,"Wrong count bracket"}
    };
    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(TEST_DATA);
    }

    @Test
    public void test() {


    }
}