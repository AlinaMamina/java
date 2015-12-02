package ru.sbpstu.appmath.mamina;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataInFile {
    public void processFile(String in_name, String out_name, String interval) throws Exception {
        final File in_file = new File(in_name);
        final File out_file = new File(out_name);

        int posColon1 = interval.indexOf(':');
        int posColon2 = interval.lastIndexOf(':');
        if (posColon1 == -1 || posColon2 == -1)
            throw new Exception("Wrong syntax");
        final int min = Integer.valueOf(interval.substring(0, posColon1));
        final int max;
        final int step;
        if (posColon1 != posColon2) {
            max = Integer.valueOf(interval.substring(posColon1 + 1, posColon2));
            step = Integer.valueOf(interval.substring(posColon2 + 1));
        } else {
            max = Integer.valueOf(interval.substring(posColon1 + 1));
            step = 1;
        }

        List<String> tasks = readFile(in_file);
        Object[][] result = new Object[(max - min) / step + 1][tasks.size()];
        for (int i = 0; i < tasks.size(); i++) {
            result[0][i] = tasks.get(i);
            final Processing proc = new Processing();
            final Expression exp;
            try {
                exp = proc.processStr(tasks.get(i));

                for (int j = min; j < max; j += step) {
                    try {
                        result[j][i] = exp.calc(j);
                    } catch (Exception e) {
                        result[j][i] = e.getMessage();
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                result[i][1] = e.getMessage();
            }

        }
        write(out_file, result);

    }

    private static List<String> readFile(File file) {
        List<String> tasks = new ArrayList<>();
        int i = 0;
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {

                tasks.add(i, scanner.nextLine());
                i++;
            }
            return tasks;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return null;

    }

    private static void write(File file, Object[][] result) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    writer.print(result[i][j] + "    ");
                }
                writer.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
