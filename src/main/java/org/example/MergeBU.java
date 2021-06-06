package org.example;

public class MergeBU {

    private static Comparable[] aux;  // auxiliary array for merges
    public static void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];
        for (int sz=1; sz < N; sz=sz+sz)  // sz: subarry size
            for(int lo =0;lo<N-sz; lo+=sz+sz)  // lo: subarray index
                Merge.merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1,N-1));
    }
}
