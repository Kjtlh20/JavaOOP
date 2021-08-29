/* Считайте из файла текст на английском языке, вычислите относительную частоту
 * повторения каждой буквы и выведите на экран результат в порядке
 * убывания относительной частоты повторения.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        File file = new File("books/John Ronald Reuel Tolkien.txt");
        TextFileReader tfr = new TextFileReader(file);
        TreeSet<LetterStatistic> letterStatictics = tfr.getLetterStatictics();
        for (LetterStatistic ls : letterStatictics) {
            System.out.println(ls.getLetter() + " -> " + ls.getCount());
        }
    }
}
