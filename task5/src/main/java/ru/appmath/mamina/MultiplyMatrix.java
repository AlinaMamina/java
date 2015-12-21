package ru.appmath.mamina;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiplyMatrix {
    private Matrix m1;
    private Matrix m2;
    private int count_thread;


    public MultiplyMatrix(Matrix m1, Matrix m2, int count_thread) {
        this.m1 = m1;
        this.m2 = m2;
        this.count_thread = count_thread;
    }

    private class Task implements Callable<Double> {
        private final int line;
        private final int column;

        private Task(int line, int column) {
            this.line = line;
            this.column = column;
        }

        public Double call() throws Exception {
            Double result = 0.0;
            for (int i = 0; i < m1.getColumns(); i++)
                result += m1.getElement(line, i) * m2.getElement(i, column);
            return result;
        }
    }


    public Matrix multiply() throws IOException {
        if (m1.getLine() != m2.getColumns())
            throw new IOException("Error");

        Matrix result = new Matrix(m1.getLine(), m2.getColumns());
        final List<Result> task = new ArrayList<Result>();
        ExecutorService service = Executors.newFixedThreadPool(count_thread);

        for (int i = 0; i < m1.getLine(); i++)
            for (int j = 0; j < m2.getColumns(); ++j) {
                Future<Double> future = service.submit(new Task(i, j));
                task.add(new Result(i, j, future));
            }

        try {
            for (Result res : task) {
                result.set(res.getX(), res.getY(), res.getValue());
            }
        } catch (Exception ignored) {
        }
        service.shutdown();
        return result;
    }

    private class Result {
        private final int x;
        private final int y;
        private Future<Double> value;

        public Result(final int x, final int y, final Future<Double> value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public Double getValue() throws Exception {
            return value.get();
        }
    }


}
