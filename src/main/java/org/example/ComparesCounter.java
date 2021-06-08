package org.example;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import static org.example.Example.less;

public class ComparesCounter {
    public static class Merge {
        private static Comparable[] aux;
        public static int compareCounter = 0;
        public static int prevCompCounter = 0;

        public static void sort(Comparable[] a) {
            compareCounter = 0;
            aux = new Comparable[a.length];
            sort(a, 0, a.length - 1);
        }

        private static void sort(Comparable[] a, int lo, int hi) {
            if (hi <= lo) return;
            int mid = lo + (hi - lo) / 2;
            sort(a, lo, mid);
            sort(a, mid + 1, hi);
            merge(a, lo, mid, hi);
        }

        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            //StdOut.println((hi - lo) + 1);
            int i = lo, j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = a[k];
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) a[k] = aux[j++];
                else if (j > hi) a[k] = aux[i++];
                else if (less(aux[j], aux[i])) {
                    compareCounter++;
                    a[k] = aux[j++];
                } else a[k] = aux[i++];
            }
        }

        private static boolean isMonotonicallyIncreasing() {
            Merge m = new Merge();
            for (int i = 1; i < 20; i++) {
                Double[] a = new Double[i];
                for (int j = 0; j < i; j++) {
                    a[j] = StdRandom.uniform();
                }
                int N = a.length;
                m.sort(a);
                if (compareCounter < prevCompCounter) return false;
                prevCompCounter = compareCounter;
            }
            return true;
        }

        public static void main(String[] args) {
            StdOut.printf("%7s",isMonotonicallyIncreasing());
        }

    }
}