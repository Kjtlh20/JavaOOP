package com.gmail.dev.surovtsev.yaroslav;

public class MultiThreadSum {

    public static long getArraySumMulti(int[] array) {
        long result = 0;
        int threadCount = Runtime.getRuntime().availableProcessors();
        ArraySum[] tasks = new ArraySum[threadCount];

        int size = array.length / threadCount;
        int startIndex = 0;
        int endIndex = size;
        for (int i = 0; i < tasks.length; i++) {
            if (i == tasks.length - 1) {
                endIndex = array.length;
            }
            tasks[i] = new ArraySum(array, startIndex, endIndex);
            startIndex = startIndex + size;
            endIndex = endIndex + size;
        }

        for (int i = 0; i < tasks.length; i++) {
            Thread thread = tasks[i].getThread();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < tasks.length; i++) {
            result = result + tasks[i].getSum();
        }

        return result;
    }
}
