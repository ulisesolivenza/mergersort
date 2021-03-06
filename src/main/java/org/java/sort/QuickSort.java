package org.java.sort;

import org.java.esort.model.Lines;
import org.java.esort.model.TString;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by ulises on 20/02/16.
 * Randomized Iterative QuickSort algorithm for in-memory sorting
 */
public class QuickSort implements SortAlg {

    @Override
    public Lines sort(Lines lines) {
        List<TString> tStrings = lines.getLines();
        quicksort(tStrings, 0, tStrings.size() - 1);
        return lines;
    }


    private void quicksort(List<TString> tStrings, int l, int h) {

        if (tStrings.size() <= 0) {
            return;
        }

        Deque<Integer> stack = new ArrayDeque<>(l - h + 1);

        stack.push(l);
        stack.push(h);

        // Keep popping from stack while is not empty
        while (!stack.isEmpty()) {
            // Pop h and l
            h = stack.pop();
            l = stack.pop();


            // Set pivot element at its correct position in sorted array
            int p = randomPartition(tStrings, l, h);

            // If there are elements on left side of pivot, then push left
            // side to stack
            if (p - 1 > l) {
                stack.push(l);
                stack.push(p - 1);

            }

            // If there are elements on right side of pivot, then push right
            // side to stack
            if (p + 1 < h) {
                stack.push(p + 1);
                stack.push(h);

            }
        }
    }


    private int randomPartition(List<TString> tStrings, int l, int h) {
        int i = ThreadLocalRandom.current().nextInt(l, h + 1);
        swap(tStrings, h, i);
        return partition(tStrings, l, h);
    }

    private int partition(List<TString> tStrings, int l, int h) {
        TString x = tStrings.get(h);
        int i = l - 1;

        for (int j = l; j <= h - 1; j++) {
            TString jj = tStrings.get(j);
            if (jj.compareTo(x) < 0) {
                i++;
                swap(tStrings, i, j);
            }
        }
        swap(tStrings, i + 1, h);
        return (i + 1);
    }

    private void swap(List<TString> tStrings, int x, int y) {
        Collections.swap(tStrings, x, y);
    }
}
