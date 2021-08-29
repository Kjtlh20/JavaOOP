package com.gmail.dev.surovtsev.yaroslav;

public interface CSVConverter {

    public String toCSVString();

    public Student fromCSVString(String str);
}
