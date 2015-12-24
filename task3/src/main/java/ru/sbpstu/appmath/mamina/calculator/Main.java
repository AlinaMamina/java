package ru.sbpstu.appmath.mamina.calculator;


import ru.sbpstu.appmath.mamina.exception.ExpException;

public class Main {
    public static void main(String[] args) {
        Double x;
        final Parser p = new Parser();
        Expression result;
        if (args.length == 2) {
            try {
                x = Double.valueOf(args[1]);
                result = p.parseStr(args[0]);
            } catch (ExpException e) {
                System.out.println(e.getMessage());
                return;
            }
            try {
                System.out.println(result.calc(x));
            } catch (ExpException e) {
                System.err.println(e.getMessage());
                return;
            }
        } else {
            System.out.println("error: wrong arguments");
        }

    }


}

