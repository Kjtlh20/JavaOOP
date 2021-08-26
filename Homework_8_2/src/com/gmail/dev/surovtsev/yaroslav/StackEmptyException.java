package com.gmail.dev.surovtsev.yaroslav;

public class StackEmptyException extends Exception {

    @Override
    public String getMessage() {
        return "Stack is empty";
    }
}
