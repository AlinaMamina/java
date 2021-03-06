package ru.sbpstu.appmath.mamina.calculator;


import ru.sbpstu.appmath.mamina.exception.BracketException;
import ru.sbpstu.appmath.mamina.exception.SymbolException;
import ru.sbpstu.appmath.mamina.exception.SyntaxException;

public class Parser {
    public Expression parseStr(String s) throws SyntaxException {

        String str = s.replace(" ", "");
        if (str.equals(""))
            throw new SyntaxException();
        if (!checkSyntax(str))
            throw new SymbolException();
        if (!countBracket(str))
            throw new BracketException();
        int lenStr = str.length();

        int pos;
        //'+'
        if ((pos = findPosNotInBracket(str, '+')) != -1)
            return new BinOperation(parseStr(str.substring(0, pos)), parseStr(str.substring(pos + 1)), '+');
        // '-'
        if ((pos = findPosNotInBracket(str, '-')) != -1)
            return new BinOperation(parseStr(str.substring(0, pos)), parseStr(str.substring(pos + 1)), '-');
        //'*'
        if ((pos = findPosNotInBracket(str, '*')) != -1)
            return new BinOperation(parseStr(str.substring(0, pos)), parseStr(str.substring(pos + 1)), '*');
        // '/'
        if ((pos = findPosNotInBracket(str, '/')) != -1)
            return new BinOperation(parseStr(str.substring(0, pos)), parseStr(str.substring(pos + 1)), '/');
        // '(' ')'
        if (str.charAt(0) == '(')
            return parseStr(str.substring(1, lenStr - 1));

        int c = 0;
        for (int i = 0; i < lenStr; i++) {

            if (str.charAt(i) == '(')
                c++;
            if (str.charAt(i) == ')')
                c--;
            if (Character.isDigit(str.charAt(i)) && c == 0) {
                return new Const(Double.valueOf(str));
            }
        }
        if (findPosNotInBracket(str, 'x') != -1)
            return new Var();
        throw new SyntaxException();
    }

    private int findPosNotInBracket(String str, char sym) {
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
        final char rightSym[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', ' ', '+', '-', '*', '/', '(', ')', 'x', '.'};
        int k = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < rightSym.length; j++) {
                if (str.charAt(i) != rightSym[j]) {
                    k++;
                }
            }
            if (k == rightSym.length)
                return false;
            k = 0;
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