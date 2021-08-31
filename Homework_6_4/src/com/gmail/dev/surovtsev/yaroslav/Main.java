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

        int n = 1_000;
        File[] files = getFilesArray(n, folderFrom);

        long timeStart = System.currentTimeMillis();
        SingleThreadCopy.copyFilesSingleThread(files, folderFrom, folderTo);
        long timeEnd = System.currentTimeMillis();
        System.out.println("Single: " + (timeEnd - timeStart) + " ms");

        timeStart = System.currentTimeMillis();
        MultiThreadCopy.copyFilesMultiThread(files, folderFrom, folderTo);
        timeEnd = System.currentTimeMillis();
        System.out.println("Multi: " + (timeEnd - timeStart) + " ms");

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
