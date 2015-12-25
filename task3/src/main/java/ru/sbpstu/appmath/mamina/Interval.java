package ru.sbpstu.appmath.mamina;


import ru.sbpstu.appmath.mamina.exception.IntervalException;

public class Interval {
    private Double min;
    private Double max;
    private Double step;


    public Interval(final String interval) throws IntervalException {
        String[] arr = interval.split(":");
        if (arr.length == 3) {
            try {
                this.min = Double.valueOf(arr[0]);
                this.max = Double.valueOf(arr[1]);
                this.step = Double.valueOf(arr[2]);
            } catch (NumberFormatException e) {
                throw new IntervalException();
            }
        } else if (arr.length == 2) {
            try {
                this.min = Double.valueOf(arr[0]);
                this.max = Double.valueOf(arr[1]);
                this.step = 1.0;
            } catch (NumberFormatException e) {
                throw new IntervalException();
            }
        } else
            throw new IntervalException();
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getStep() {
        return step;
    }
}
