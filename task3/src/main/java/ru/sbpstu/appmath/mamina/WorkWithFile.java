package ru.sbpstu.appmath.mamina;

import ru.sbpstu.appmath.mamina.calculator.Expression;
import ru.sbpstu.appmath.mamina.calculator.Parser;
import ru.sbpstu.appmath.mamina.exception.ExpException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WorkWithFile {
    public void parseFile(final String in_name, final String out_name, final Double min, final Double max, final Double step) throws ExpException {
        final File inFile = new File(in_name);
        final File outFile = new File(out_name);
        if(!inFile.exists() || !outFile.exists()){
            throw new ExpException("File not found!");
        }
        final List<String> tasks = readFile(inFile);
        final Double d = (max - min) / step + 1;
        final Integer s = d.intValue();
        final Object[][] result = new Object[s][tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            result[0][i] = tasks.get(i);
            final Parser p = new Parser();
            Expression exp;
            int index = 1;
            for (Double j = min; j < max; j += step) {
                try {
                    exp = p.parseStr(tasks.get(i));
                    result[index][i] = exp.calc(j);
                } catch (ExpException e) {
                    result[index][i] = e.getMessage();
                } finally {
                    index++;
                }
            }
        }
        write(outFile, result);

    }

    private static List<String> readFile(File file) {
        List<String> tasks = new ArrayList<>();
        int i = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            tasks.add(i, scanner.nextLine());
            i++;
        }
        scanner.close();
        return tasks;
    }


    private static void write(File file, Object[][] result) {
        try (PrintWriter writer = new PrintWriter(file)) {
            int len[] = maxWidthColumn(result);
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    if (result[i].length != 1) {
                        int numSpaces = len[j] - result[i][j].toString().length();
                        for (int k = 0; k < numSpaces; k++)
                            writer.print(" ");
                        writer.print(result[i][j]);
                        if (i - 1 != result.length)
                            writer.print("   ");
                    }
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[] maxWidthColumn(Object[][] a) {
        int max[] = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            max[i] = a[i][0].toString().length();
            for (int j = 0; j < a[0].length; j++)
                if (max[i] < a[i][j].toString().length())
                    max[i] = a[i][j].toString().length();
        }
        return max;
    }
}
