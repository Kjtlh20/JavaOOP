package com.gmail.dev.surovtsev.yaroslav;

import java.math.BigInteger;

public class FactorialCalculate implements Runnable {
    private int n;

    public FactorialCalculate() {
    }

    public FactorialCalculate(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public BigInteger factorial(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            f = f.multiply(BigInteger.valueOf(i));
        }
        return f;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + "(" + thread.getId() + ") " + n + "! = " + factorial(n));
    }

    @Override
    public String toString() {
        return "FactorialCalculate{" +
                "n=" + n +
                '}';
    }
}
