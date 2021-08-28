package com.gmail.dev.surovtsev.yaroslav;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> progLangList = new ArrayList<>();
        progLangList.add("PHP");
        progLangList.add("Objective-C");
        progLangList.add("Python");
        progLangList.add("Java");
        progLangList.add("JavaScript");
        progLangList.add("C#");
        progLangList.add("C");
        progLangList.add("C++");
        progLangList.add("Swift");
        progLangList.add("Go");
        System.out.println(progLangList);
        progLangList.remove(0);
        progLangList.remove(0);
        progLangList.remove(progLangList.size() - 1);
        System.out.println(progLangList);
    }
}
