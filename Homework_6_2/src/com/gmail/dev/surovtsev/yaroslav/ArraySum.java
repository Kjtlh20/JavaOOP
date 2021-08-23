package com.gmail.dev.surovtsev.yaroslav;

public class ArraySum implements Runnable {
    private int[] array;
    private int startIndex;
    private int endIndex;
    private long sum;
    private Thread thread;

    public ArraySum() {
    }

    public ArraySum(int[] array, int startIndex, int endIndex) {
        this.array = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        thread = new Thread(this);
        thread.start();
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public long getSum() {
        return sum;
    }

    public void setSum(long sum) {
        this.sum = sum;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            sum = sum + array[i];
        }
    }

    @Override
    public String toString() {
        return "ArraySum{" +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", sum=" + sum +
                '}';
    }
}
