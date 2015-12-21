package ru.appmath.mamina;

import java.io.File;
import java.io.PrintWriter;

public class Main {

    public static void printInFile(File outFile, Matrix res) throws Exception {
        PrintWriter printWriter = new PrintWriter(outFile);
        for (int i = 0; i < res.getColumns(); i++) {
            for (int j = 0; j < res.getLine(); j++)
                printWriter.print(res.getElement(i, j) + " ");
            printWriter.println();
        }
        printWriter.close();
    }

    public static void main(String[] args) {
        try {
            if (args.length > 5) {
                System.out.println("Wrong argumets");
                return;
            }
            if (args.length < 3) {
                System.out.println("Wrong argumets");
                return;
            }
            File file1 = new File(args[0]);
            File file2 = new File(args[1]);
            File out_file = new File(args[2]);
            Matrix m1 = new Matrix(file1);
            Matrix m2 = new Matrix(file2);
            int count_thread = 1;
            if (args.length == 4)
                count_thread = Integer.valueOf(args[3]);
            Matrix result = new MultiplyMatrix(m1, m2, count_thread).multiply();
            printInFile(out_file, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}