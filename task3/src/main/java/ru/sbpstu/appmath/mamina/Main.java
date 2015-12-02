package ru.sbpstu.appmath.mamina;

public class Main {
    public static void main(String[] args) {
        double x = 0;
        final Processing proc = new Processing();
        Expression result = null;
        if (args.length == 2) {
            try {
                x = Double.valueOf(args[1]);
                result = proc.processStr(args[0]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                System.out.println(result.calc(x));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }else if (args.length == 3) {
                final DataInFile file = new DataInFile();
                try {
                    file.processFile(args[0], args[1], args[2]);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
            else {
            System.out.println("error: wrong arguments");
            }
    }
}

