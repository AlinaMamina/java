package ru.appmath.mamina;

import java.io.File;
import java.io.PrintWriter;

public class Main {


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
            File outFile = new File(args[2]);
            Matrix m1 = OperationWithFile.readMatrix(file1);
            Matrix m2 = OperationWithFile.readMatrix(file2);
            int countThread = 1;
            if (args.length == 4)
                countThread = Integer.valueOf(args[3]);
            Matrix result = new MatrixMultiplication(m1, m2, countThread).multiply();
            OperationWithFile.printInFile(outFile, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}