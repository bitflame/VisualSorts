package org.example;


import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
@SuppressWarnings("Unchecked")
public class Example {
    public static void sort(Comparable[] a) throws InterruptedException {
        Selection s = new Selection();
        Client c = new Client();
        StdOut.println("Here is Selection sort time: "+c.time("Selection",a));
        StdOut.println("Here is Selection sort time: "+c.time("Insertion",a));
        s.sort(a);
        StdOut.println("Here is the result of selection sort.");
        show(a);
        Insertion i = new Insertion();
        i.sort(a);
        StdOut.println("Here is the result of insertion sort.");
    }
    public static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
    private static void show (Comparable[] a) {
        for (int i =0; i < a.length; i++) {
            StdOut.print(a[i]+" ");
            StdOut.println();
        }
    }
    public static void exch(Comparable[] a, int i, int j) {
        Comparable t=a[i]; a[i]=a[j];a[j]=t;
    }
    public  static boolean isSorted (Comparable[] a) {
        for (int i =1;i < a.length; i++)
          if (less(a[i],a[i-1])) return false;
          return true;
    }
    public static void main(String [] args) throws InterruptedException {
        String [] a= In.readStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }
}