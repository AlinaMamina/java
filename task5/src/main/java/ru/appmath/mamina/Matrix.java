package ru.appmath.mamina;

public class Matrix {
    private int countLines;
    private int countColumns;
    private double[][] data;

    public Matrix(final int countLine, final int countColumn) {
        this.countLines = countLine;
        this.countColumns = countColumn;
        this.data = new double[countLine][countColumn];
    }

    public Matrix(double[][] data) {
        this.data = data;
    }

    public int getLine() {
        return this.countLines;
    }

    public int getColumns() {
        return this.countColumns;
    }

    public Double getElement(final int i, final int j) {
        return this.data[i][j];
    }

    public void set(final int i, final int j, final double value) {
        this.data[i][j] = value;
    }

}

