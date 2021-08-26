package com.gmail.dev.surovtsev.yaroslav;

import java.util.Arrays;

public class Stack {
    private int topOfStack;
    private int size;
    private Object[] array;

    public Stack() {
    }

    public Stack(int size) {
        this.topOfStack = -1;
        this.size = size;
        this.array = new Object[size];
    }

    public int getSize() {
        return size;
    }

    public void push(Object obj) throws StackOverflowException {
        if (topOfStack >= array.length - 1) {
            throw new StackOverflowException();
        }
        topOfStack = topOfStack + 1;
        array[topOfStack] = obj;
    }

    public Object pop() throws StackEmptyException {
        if (topOfStack == -1) {
            throw new StackEmptyException();
        }
        Object element = array[topOfStack];
        array[topOfStack] = null;
        topOfStack = topOfStack - 1;
        return element;
    }

    public Object peek() throws StackEmptyException {
        if (topOfStack == -1) {
            new StackEmptyException();
        }
        Object element = array[topOfStack];
        return element;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "topOfStack=" + topOfStack +
                ", size=" + size +
                ", array=" + Arrays.toString(array) +
                '}';
    }
}
