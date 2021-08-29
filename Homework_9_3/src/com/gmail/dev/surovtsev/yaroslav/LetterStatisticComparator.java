package com.gmail.dev.surovtsev.yaroslav;

import java.util.Comparator;

public class LetterStatisticComparator implements Comparator<LetterStatistic> {

    @Override
    public int compare(LetterStatistic o1, LetterStatistic o2) {
        return o2.getCount() - o1.getCount();
    }
}
