/* 1) Создайте сто потоков, которые будут вычислять факториал
 * числа, равного номеру этого потока, и выводить результат на
 * экран.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Thread " + mainThread.getName() + " start");
        boolean sync = false;

        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            FactorialCalculate task = new FactorialCalculate(i);
            threads[i] = new Thread(task);
            threads[i].start();
            if (sync) {
                try {
                    threads[i].join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Thread " + mainThread.getName() + " stop");
    }
}
