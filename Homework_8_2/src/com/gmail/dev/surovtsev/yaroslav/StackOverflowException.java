package com.gmail.dev.surovtsev.yaroslav;

public class StackOverflowException extends Exception {

    @Override
    public String getMessage() {
        return "Stack is overflow";
    }
}
