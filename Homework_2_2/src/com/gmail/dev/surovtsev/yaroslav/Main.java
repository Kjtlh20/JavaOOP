package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        TextTransformer textTransformer = new TextTransformer();
        System.out.println(textTransformer.transform("hello"));
        InverseTransformer inverseTransformer = new InverseTransformer();
        System.out.println(inverseTransformer.transform("hello"));
        UpDownTransformer upDownTransformer = new UpDownTransformer();
        System.out.println(upDownTransformer.transform("hello"));
        File file1 = new File("New file1.txt");
        TextSaver textSaver1 = new TextSaver(textTransformer, file1);
        textSaver1.saveTextToFile("hello");
        File file2 = new File("New file2.txt");
        TextSaver textSaver2 = new TextSaver(inverseTransformer, file2);
        textSaver2.saveTextToFile("hello");
        File file3 = new File("New file3.txt");
        TextSaver textSaver3 = new TextSaver(upDownTransformer, file3);
        textSaver3.saveTextToFile("hello");
    }
}
