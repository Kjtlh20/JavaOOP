/* 1) Реализуйте сервис для сравнения файлов на идентичность. Файлы считаются идентичными если
 * они побайтово равны. Файлы разной длинны, или файлы в которых хотя бы один байт отличен
 * считаются разными.
 * 2) Дополните полученный сервис возможностью передачи адресов файлов в ключевом режиме при
 * запуске приложения из командной строки.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String fileName1;
        String fileName2;
        if (args.length >= 2) {
            fileName1 = args[0];
            fileName2 = args[1];
        } else {
            fileName1 = "files/Text file 1.txt";
            fileName2 = "files/Text file 2.txt";
        }
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        try {
            boolean comparRes = FileComparer.compareFiles(file1, file2);
            if (comparRes) {
                System.out.println("File <" + file1.getName() + "> is identical to file <" + file2.getName() + ">");
            } else {
                System.out.println("File <" + file1.getName() + "> is not identical to file <" + file2.getName() + ">");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
