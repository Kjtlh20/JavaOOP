package com.gmail.dev.surovtsev.yaroslav;

import java.lang.StringBuilder;
import java.util.Locale;

public class UpDownTransformer extends TextTransformer {

    public UpDownTransformer() {
        super();
    }

    @Override
    public String transform(String text) {
        char[] charArray = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            String letter = String.valueOf(charArray[i]);
            if ((i + 1) % 2 == 0) {
                sb.append(letter.toLowerCase());
            } else {
                sb.append(letter.toUpperCase());
            }
        }
        return sb.toString();
    }
}
