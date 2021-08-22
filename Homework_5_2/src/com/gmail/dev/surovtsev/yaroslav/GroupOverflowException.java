package com.gmail.dev.surovtsev.yaroslav;

public class GroupOverflowException extends Exception {

    @Override
    public String getMessage() {
        return "Group overflow";
    }
}
