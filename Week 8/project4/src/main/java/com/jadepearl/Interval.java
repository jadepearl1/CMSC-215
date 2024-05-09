package com.jadepearl;

public class Interval<T extends Comparable<T>> {
    private final T start;
    private final T end;

    public Interval(T start, T end) {
        this.start = start;
        this.end = end;
    }

    public boolean within(T value) {
        return end.compareTo(value) >= 0 && start.compareTo(value) <= 0;
    }

    public boolean subinterval(Interval<T> interval) {
        return start.compareTo(interval.start) >= 0 && end.compareTo(interval.end) <= 0;
    }

    public boolean overlaps(Interval<T> interval) {
        return end.compareTo(interval.start) >= 0 && start.compareTo(interval.end) <= 0;
    }
}
