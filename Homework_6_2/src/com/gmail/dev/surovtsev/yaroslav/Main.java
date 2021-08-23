/* 2) Написать код для многопоточного подсчета суммы элементов
 * массива целых чисел. Сравнить скорость подсчета с простым
 * алгоритмом.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Thread " + mainThread.getName() + " start");

        int n = 300_000_000;
        int[] array = getArray(n);

        long timeStart = System.currentTimeMillis();
        long sum1 = getSum(array);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Sum1: " + sum1);
        System.out.println("Single: " + (timeEnd - timeStart) + " ms");

        timeStart = System.currentTimeMillis();
        long sum2 = MultiThreadSum.getArraySumMulti(array);
        timeEnd = System.currentTimeMillis();
        System.out.println("Sum2: " + sum2);
        System.out.println("Multi: " + (timeEnd - timeStart) + " ms");

        System.out.println("Thread " + mainThread.getName() + " stop");
    }

    public static long getSum(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static int[] getArray(int n) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(100000000);
        }
        return array;
    }
}
