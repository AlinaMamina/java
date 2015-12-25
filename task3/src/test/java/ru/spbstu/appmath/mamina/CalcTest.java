package ru.spbstu.appmath.mamina;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.sbpstu.appmath.mamina.calculator.Expression;
import ru.sbpstu.appmath.mamina.calculator.Parser;
import ru.sbpstu.appmath.mamina.exception.ExpException;
import ru.sbpstu.appmath.mamina.exception.SyntaxException;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalcTest {

        private final String expression;
        private final Double var;
        private final Double answer;

        public CalcTest(String expression, Double var, Double answer) {
            this.expression = expression;
            this.var = var;
            this.answer = answer;
        }

        private static final Object[][] TEST_DATA = new Object[][]{
                {"x", 0.0, 0.0},
                {"1+x*x ", 2.0, 5.0},
                {"x+(x-3)*5", 1.0, -9.0},
                {"1/x - x +1.23 ", 2.0, -0.27}
        };


        @Parameterized.Parameters
        public static Collection<Object[]> testData() {
            return Arrays.asList(TEST_DATA);
        }

        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        @Test
        public void test() throws ExpException {
            final Parser p = new Parser();

            Expression f = p.parseStr(expression);
            Assert.assertEquals(f.calc(var), answer);

        }

}



