package ru.appmath.mamina;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestMatrix {
    private Matrix m1;
    private Matrix m2;
    private Matrix res;
    private int count_thread;


    private final static Object[][] TEST = new Object[][]{
            {new Double[][]{{0.0}}, new Double[][]{{0.0}}, new Double[][]{{0.0}}, 1},
            {new Double[][]{{1.0, 1.0}, {2.0 ,2.0}}, new Double[][]{{2.0, 2.0}, {1.0, 1.0}}, new Double[][]{{3.0, 3.0}, {6.0, 6.0}}, 1},
            {new Double[][]{{1.0, 1.0}, {2.0, 2.0}}, new Double[][]{{2.0, 2.0}, {1.0, 1.0}}, new Double[][]{{3.0, 3.0}, {6.0, 6.0}}, 2},
            {new Double[][]{{1.0, 1.0,1.0}, {2.0, 2.0, 2.0}}, new Double[][]{{2.0, 2.0}, {1.0, 1.0},{3.0,3.0}}, new Double[][]{{6.0, 6.0}, {12.0, 12.0}}, 2},
            {new Double[][]{{1.0, 1.0,1.0}, {2.0, 2.0,2.0}}, new Double[][]{{2.0, 2.0}, {1.0, 1.0},{3.0,3.0}}, new Double[][]{{6.0, 6.0}, {12.0, 12.0}}, 3}
    };

    public TestMatrix(Double[][] m1, Double[][] m2, Double[][] res, Integer count_thread) {
        this.m1 = new Matrix(m1);
        this.m2 = new Matrix(m2);
        this.res = new Matrix(res);
        this.count_thread = count_thread;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() throws Exception {
        return Arrays.asList(TEST);
    }

    @Test
    public void test() {
        try {
            Matrix result = new MultiplyMatrix(m1, m2, count_thread).multiply();
            Assert.assertTrue(compare(res, result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean compare(final Matrix m1, final Matrix m2) {
        if (m1.getLine() != m2.getLine() && m1.getColumns() != m2.getColumns())
            return false;
        for (int i = 0; i < m1.getLine(); i++) {
            for (int j = 0; j < m1.getColumns(); j++) {
                if (!m1.getElement(i, j).equals(m2.getElement(i, j)))
                    return false;
            }
        }
        return true;
    }


}

