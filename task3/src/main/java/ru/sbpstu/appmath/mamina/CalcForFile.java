package ru.sbpstu.appmath.mamina;

import ru.sbpstu.appmath.mamina.exception.ExpException;

import java.io.FileNotFoundException;

public class CalcForFile {
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 3) {
            final WorkWithFile file = new WorkWithFile();
            try {
                Interval p = new Interval(args[2]);
                file.parseFile(args[0], args[1], p.getMin(), p.getMax(), p.getStep());
            } catch (ExpException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("error: wrong arguments");
        }
    }
}
