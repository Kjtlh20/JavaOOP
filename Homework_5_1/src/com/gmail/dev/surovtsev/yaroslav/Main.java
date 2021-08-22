/*1) Напишите программу, которая скопирует все файлы с заранее определенным расширением
 * (например, только doc) из одного каталога в другой.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File in = new File("NewFolder1/");
        File out = new File("NewFolder2/");
        try {
            FileCopyService.copyDocFiles(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
