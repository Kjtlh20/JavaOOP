package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class DictionaryCreator {
    private Map<String, String> dict;

    public DictionaryCreator() {
    }

    public DictionaryCreator(Map<String, String> dict) {
        this.dict = dict;
    }

    public Map<String, String> getDict() {
        return dict;
    }

    public void setDict(Map<String, String> dict) {
        this.dict = dict;
    }

    public void fill() {
        dict = new HashMap<>();
        System.out.println("Welcome to dictionary creator");
        System.out.println("If you want exit, input exit0");
        Scanner sc = new Scanner(System.in);
        for (; ; ) {
            System.out.println("Input english word");
            String lineIn = sc.nextLine();
            if (lineIn.equals("exit0")) {
                break;
            }
            System.out.println("Input translation");
            String lineOut = sc.nextLine();
            dict.put(lineIn, lineOut);
        }
    }

    public void saveToCSV() {
        System.out.println("Input filename");
        Scanner sc = new Scanner(System.in);
        String filename = sc.nextLine();
        filename = filename + ".csv";
        String sep = ";";
        File file = new File("dictionaries/", filename);
        try (PrintWriter pw = new PrintWriter(file)) {
            Set<Map.Entry<String, String>> set = dict.entrySet();
            for (Map.Entry<String, String> element : set) {
                pw.println(element.getKey() + " -> " + element.getValue() + sep);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "DictionaryCreator{" +
                "dict=" + dict +
                '}';
    }
}
