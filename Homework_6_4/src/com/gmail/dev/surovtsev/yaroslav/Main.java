/* 4) Реализуйте многопоточное копирование каталога,
 * содержащего несколько файлов.
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File folderFrom = new File("NewFolder1");
        if (!folderFrom.exists()) {
            folderFrom.mkdir();
        }
        File folderTo = new File("NewFolder2");
        if (!folderTo.exists()) {
            folderTo.mkdir();
        }

        Thread mainThread = Thread.currentThread();
        System.out.println("Thread " + mainThread.getName() + " start");

        int n = 100;
        File[] files = getFilesArray(n, folderFrom);
        MultiThreadCopy.copyFilesMultiThread(files, folderFrom, folderTo);

        System.out.println("Thread " + mainThread.getName() + " stop");
    }

    public static File[] getFilesArray(int n, File folderFrom) {
        File[] files = new File[n];
        for (int i = 0; i < n; i++) {
            File file = new File(folderFrom, "file" + i + ".txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            files[i] = file;
        }
        return files;
    }
}
