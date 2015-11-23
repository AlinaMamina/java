package ru.sbpstu.appmath.mamina;


public class Processing {
    public Expression processStr(String str) throws Exception {

        if (str.equals(""))
            throw new Exception("Syntax error!");
        if (!checkSyntax(str))
            throw new Exception("Syntax error!");
        if (!countBracket(str))
            throw new Exception("Count Bracket!");
        int lenStr = str.length();
        int pos;
        //'+'
        if ((pos = findPos(str, '+')) != -1)
            return new ExpTree(processStr(str.substring(0, pos)), processStr(str.substring(pos + 1)), '+');
        // '-'
        if ((pos = findPos(str, '-')) != -1)
            return new ExpTree(processStr(str.substring(0, pos)), processStr(str.substring(pos + 1)), '-');
        //'*'
        if ((pos = findPos(str, '*')) != -1)
            return new ExpTree(processStr(str.substring(0, pos)), processStr(str.substring(pos + 1)), '*');
        // '/'
        if ((pos = findPos(str, '/')) != -1)
            return new ExpTree(processStr(str.substring(0, pos)), processStr(str.substring(pos + 1)), '/');
        // '(' ')'
        if (str.charAt(0) == '(')
            return processStr(str.substring(1, lenStr - 1));

        int c = 0;
        for (int i = 0; i < lenStr; i++) {

            if (str.charAt(i) == '(')
                c++;
            if (str.charAt(i) == ')')
                c--;
            //character what is it???
            if (Character.isDigit(str.charAt(i)) && c == 0) {
                return new Const(Double.valueOf(str));
            }
        }
        if (findPos(str, 'x') != -1)
            return new Var();
        throw new Exception("Syntax error!");
    }

    private int findPos(String str, char sym) {
        int c = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                c++;
            if (str.charAt(i) == ')')
                c--;
            if (str.charAt(i) == sym && c == 0) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkSyntax(String str) {
        char rightSym[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '+', '-', '*', '/', '(', ')', 'x'};
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < rightSym.length; j++) {
                if (str.charAt(i) == rightSym[j]) {
                    flag = true;
                }
            }
            if (flag == false)
                return false;
        }
        return true;
    }

    private boolean countBracket(String str) {
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                countLeft++;
            if (str.charAt(i) == ')')
                countRight++;
        }
        if (countLeft != countRight)
            return false;
        return true;
    }
}