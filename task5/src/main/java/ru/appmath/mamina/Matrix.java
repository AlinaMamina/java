package ru.appmath.mamina;

import java.io.File;
import java.util.Scanner;

public class Matrix {
    private int count_lines;
    private int count_columns;
    private Double[][] data;

    public Matrix(final int count_line, final int count_column) {
        this.count_lines = count_line;
        this.count_columns = count_column;
        this.data = new Double[count_line][count_column];

    }
    public Matrix(Double[][] data) {
        this.data = data;
    }

    public Matrix(File file) throws Exception {
        count_lines = 0;
        count_columns = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            if (count_columns == 0)
                count_columns = line.length;
            if (count_columns != line.length)
                throw new Exception();
            count_lines ++;
        }

        scanner.close();

        this.data = new Double[count_lines][count_columns];
        scanner = new Scanner(file.getAbsoluteFile());
        for (int i = 0; i < count_lines; i++) {
            for (int j = 0; j < count_columns; j++) {
                this.data[i][j] = scanner.nextDouble();
            }
        }
    }

    public int getLine() {
        return this.count_lines;
    }

    public int getColumns() {
        return this.count_columns;
    }

    public Double getElement(final int i, final int j) {
        return this.data[i][j];
    }

    public void set(final int i, final int j, final double value) {
        this.data[i][j] = value;
    }


}

