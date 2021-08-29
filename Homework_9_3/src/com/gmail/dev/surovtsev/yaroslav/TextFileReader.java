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

    public TreeSet<LetterStatistic> getLetterStatictics() {
        List<Character> charList = getCharList();
        charList = filterOnlyChar(charList);

        List<LetterStatistic> letterStatisticList = new ArrayList<>();
        for (Character letter : charList) {
            LetterStatistic ls = getLetterStatisticFromList(letterStatisticList, letter);
            if (ls == null) {
                ls = new LetterStatistic(letter, 1);
                letterStatisticList.add(ls);
            } else {
                ls.setCount(ls.getCount() + 1);
            }
        }

        TreeSet<LetterStatistic> letterStatictics = new TreeSet<>(new LetterStatisticComparator());
        for (LetterStatistic ls : letterStatisticList) {
            letterStatictics.add(ls);
        }
        return letterStatictics;
    }

    private LetterStatistic getLetterStatisticFromList(List<LetterStatistic> letterStatictics, Character letter) {
        LetterStatistic result = null;
        for (LetterStatistic ls : letterStatictics) {
            if (ls.getLetter().equals(letter)) {
                result = ls;
                break;
            }
        }
        return result;
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
