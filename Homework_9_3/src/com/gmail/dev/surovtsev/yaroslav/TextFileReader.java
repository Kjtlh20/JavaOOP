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

    public File getBook() {
        return file;
    }

    public void setBook(File book) {
        this.file = book;
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

    private <K, V> K getKey(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void printLetterStatictics() {
        List<Character> charList = getCharList();
        charList = filterOnlyChar(charList);
        Map<Character, Integer> letterStatictics = new HashMap<>();
        for (Character key : charList) {
            if (!letterStatictics.containsKey(key)) {
                letterStatictics.put(key, 1);
            } else {
                Integer value = letterStatictics.get(key);
                letterStatictics.put(key, value + 1);
            }
        }
        List<Integer> valueList = new ArrayList<>(letterStatictics.values());
        Collections.sort(valueList, Collections.reverseOrder());
        for (Integer value : valueList) {
            Character key = getKey(letterStatictics, value);
            System.out.println(key + " -> " + value);
        }
    }

    @Override
    public String toString() {
        return "TextFileReader{" +
                "file=" + file +
                '}';
    }
}
