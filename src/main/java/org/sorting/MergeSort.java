package org.sorting;

import org.textstring.TextString;

import java.util.Collections;
import java.util.List;

/**
 * Created by ulises on 17/02/16.
 */
public class MergeSort implements SortingAlgorithm {

    @Override
    public void sort(List<TextString> lines) {
        Collections.sort(lines);
    }
}
