package org.example;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Selection {
    public static void sort(Comparable[] a) throws InterruptedException {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int min = i;
            show(a, i);
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                    show(a, min);
                }
            }
            exch(a, i, min);
            show(a, i);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a, int min) throws InterruptedException {
        StdDraw.setPenRadius(0.01);
        StdDraw.setScale(-.05, 5);
        Double interval = 0.1;
        Thread.sleep(800);
        StdDraw.clear();
        for (int i = 0; i < a.length; i++) {
            if (i == min) {
                StdDraw.setPenColor(StdDraw.RED);
                StdDraw.line(interval, 0.0, interval, (double) a[i]);
            } else if (i > min) {
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.line(interval, 0.0, interval, (double) a[i]);
            } else {
                StdDraw.setPenColor(StdDraw.GRAY);
                StdDraw.line(interval, 0.0, interval, (double) a[i]);
            }
            interval = interval + 0.1;
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        Double[] a = new Double[50];
        for (int t = 0; t < 50; t++) {
            for (int i = 0; i < 50; i++)
                a[i] = StdRandom.uniform();
        }
        sort(a);
        assert isSorted(a);
    }
}
