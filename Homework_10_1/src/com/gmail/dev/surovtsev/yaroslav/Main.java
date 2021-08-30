/* Написать программу - переводчик, которая будет переводить текст в файле English.in,
 * написанный на английском языке, на украинский язык, согласно заранее составленному словарю.
 * Результат сохранить в файл Ukrainian.out.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        File fileIn = new File("files_translator/English.in.csv");
        File fileOut = new File("files_translator/Ukrainian.out.csv");
        Map<String, String> dict = new HashMap<>();
        dict.put("cat", "кіт");
        dict.put("dog", "собака");
        dict.put("apple", "яблуко");
        dict.put("summer", "літо");
        dict.put("sun", "сонце");
        dict.put("sand", "пісок");
        FileTranslator ft = new FileTranslator(fileIn, fileOut, dict);
        ft.translate();
    }
}
