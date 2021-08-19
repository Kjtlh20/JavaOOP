package com.gmail.dev.surovtsev.yaroslav;

import java.lang.StringBuilder;

public class InverseTransformer extends TextTransformer {

    public InverseTransformer() {
        super();
    }

    @Override
    public String transform(String text) {
        StringBuilder sb = new StringBuilder(text);
        return sb.reverse().toString();
    }
}
