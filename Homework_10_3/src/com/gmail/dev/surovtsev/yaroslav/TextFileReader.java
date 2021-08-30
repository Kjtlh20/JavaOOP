package com.gmail.dev.surovtsev.yaroslav;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TextFileReader {
    private File file;

    public TextFileReader() {
    }

    public TextFileReader(File book) {
        this.file = book;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Set<Map.Entry<Character, Integer>> getLetterStatictics() {
        List<Character> charList = getCharList();
        charList = filterOnlyChar(charList);
        Map<Character, Integer> dict = new HashMap<>();
        for (Character element : charList) {
            Integer value = dict.get(element);
            if (value == null) {
                dict.put(element, 1);
            } else {
                dict.put(element, value + 1);
            }
        }
        Set<Map.Entry<Character, Integer>> sortedSet = new TreeSet<Map.Entry<Character, Integer>>(
                new Comparator<Map.Entry<Character, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                        return o2.getValue() - o1.getValue();
                    }
                });
        sortedSet.addAll(dict.entrySet());
        return sortedSet;
    }

    private List<Character> getCharList() {
        List<Character> charList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            for (; ; ) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                line = line.toUpperCase();
                char[] chars = line.toCharArray();
                for (Character character : chars) {
                    charList.add(character);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return charList;
    }

    private List<Character> filterOnlyChar(List<Character> charList) {
        List<Character> filteredCharList = new ArrayList<>();
        for (Character character : charList) {
            int charNumber = (int) character;
            if (charNumber >= 65 && charNumber <= 90) {
                filteredCharList.add(character);
            }
        }
        return filteredCharList;
    }

    @Override
    public String toString() {
        return "TextFileReader{" +
                "file=" + file +
                '}';
    }
}
