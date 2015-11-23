package ru.sbpstu.appmath.mamina;

public class ExpTree implements Expression {
    private final Expression left;
    private final Expression right;
    private final char operation;

    public ExpTree(Expression left, Expression right, char operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public double calc(double x) throws Exception {
        double res_left = left.calc(x);
        double res_right = right.calc(x);
        switch (operation) {
            case '+':
                return (res_left + res_right);
            case '-':
                return (res_left - res_right);
            case '*':
                return (res_left * res_right);
            case '/':
                if (res_right != 0)
                    return (res_left / res_right);
                else
                    throw new Exception("math error");
            default:
                return 0;
        }
    }
}

