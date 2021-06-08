package org.example;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static org.example.Example.less;
import static org.example.Example.sort;

public class AccessCounter {

    private static class Merge {
        private Comparable[] aux;
        int accessCounter = 0;

        public void sort(Comparable[] a) {
            if (a.length < 2) {
                return;
            }
            aux = new Comparable[a.length];
            accessCounter=0;
            sort(a, 0, a.length - 1);
        }

        private void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        public void merge(Comparable[] a, int lo, int mid, int hi) {
            //StdOut.println((hi - lo) + 1);
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
                /* One for each array */
                accessCounter += 1;
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    a[k] = aux[j++];
                    accessCounter += 1;
                } else if (j > hi) {
                    a[k] = aux[i++];
                    accessCounter += 1;
                } else if (less(aux[j], aux[i])) {
                    a[k] = aux[j++];
                    accessCounter += 1;
                } else {
                    a[k] = aux[i++];
                    accessCounter += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Merge m = new Merge();
        StdOut.println("Array size        Number of Accesses");
        for (int i = 1; i < 513; i++) {
            Double[] a = new Double[i];
            int N = a.length;
            for (int j = 0; j < N; j++) {
                a[j] = StdRandom.uniform();
            }
            m.sort(a);
            double upperBound = (6 * N * (Math.log10(N)/Math.log10(2)));
            //StdOut.println(i + "              " + m.accessCounter);
            StdOut.printf("%6d %15d %11.0f\n", N, m.accessCounter,upperBound);
        }
    }
}
