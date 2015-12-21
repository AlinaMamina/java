package ru.appmath.mamina;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Time {

    private static void createRandom(Matrix m) {
        Random random = new Random();
        for (int i = 0; i < m.getLine(); i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                m.set(i, j, random.nextDouble());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try {
            measureTime(10, 15, new File("src/res1.txt"));
            measureTime(100, 150, new File("src/res2.txt"));
            measureTime(400, 500, new File("src/res3.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void measureTime(int rows, int columns, File file) throws IOException {
        int threads = 1;

        Matrix m1 = new Matrix(rows, columns);
        createRandom(m1);
        Matrix m2 = new Matrix(columns, rows);
        createRandom(m2);


        PrintWriter printWriter = new PrintWriter(file);
        for (threads = 1; threads <= 1000; threads *= 10) {
            MultiplyMatrix multiplyMatrix = new MultiplyMatrix(m1, m2, threads);
            long beginTime = System.currentTimeMillis();
            multiplyMatrix.multiply();
            long endTime = System.currentTimeMillis() - beginTime;
            printWriter.println(threads + "\t" + endTime);
        }
        printWriter.close();
    }
}

