package org.example;
import edu.princeton.cs.algs4.Stopwatch;

public class Client {
    public static double time(String alg, Comparable[]a) throws InterruptedException {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        return timer.elapsedTime();
    }
}
