package ru.appmath.mamina;

import ru.appmath.mamina.exception.MatrixCalcException;
import ru.appmath.mamina.exception.SizeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class OperationWithFile {
    public static void printInFile(File outFile, Matrix res) throws Exception {
        PrintWriter printWriter = new PrintWriter(outFile);
        for (int i = 0; i < res.getColumns(); i++) {
            for (int j = 0; j < res.getLine(); j++)
                printWriter.print(res.getElement(i, j) + " ");
            printWriter.println();
        }
        printWriter.close();
    }

    public static Matrix readMatrix(File file) throws MatrixCalcException, FileNotFoundException {
        int countColumns = 0;
        int countLines = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            if (countColumns == 0)
                countColumns = line.length;
            if (countColumns != line.length) {
                scanner.close();
                throw new SizeException();
            }
            countLines++;
        }
        scanner.close();

        Matrix m = new Matrix(countLines, countColumns);
        scanner = new Scanner(file.getAbsoluteFile());
        for (int i = 0; i < countLines; i++) {
            for (int j = 0; j < countColumns; j++) {
                m.set(i, j, scanner.nextDouble());
            }
        }
        scanner.close();
        return m;
    }
}
