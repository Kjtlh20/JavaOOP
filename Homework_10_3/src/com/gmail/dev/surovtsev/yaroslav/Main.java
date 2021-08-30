/* Решить задачу подсчета повторяющихся элементов в массиве с помощью HashMap.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        File file = new File("books/John Ronald Reuel Tolkien.txt");
        TextFileReader tfr = new TextFileReader(file);
        Set<Map.Entry<Character, Integer>> set = tfr.getLetterStatictics();
        for (Map.Entry<Character, Integer> element : set) {
            System.out.println(element.getKey() + " -> " + element.getValue());
        }
    }
}
