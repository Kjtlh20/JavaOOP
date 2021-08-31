package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.io.IOException;

public class FilesArray implements Runnable {
    private File[] files;
    private int startIndex;
    private int endIndex;
    private File folderFrom;
    private File folderTo;
    private Thread thread;

    public FilesArray() {
    }

    public FilesArray(File[] files, int startIndex, int endIndex, File folderFrom, File folderTo) {
        this.files = files;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.folderFrom = folderFrom;
        this.folderTo = folderTo;
        this.thread = new Thread(this);
        this.thread.start();
    }

    public File[] getFiles() {
        return files;
    }

    public void setFiles(File[] files) {
        this.files = files;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        for (int i = startIndex; i < endIndex; i++) {
            try {
                FileCopyService.copyFileFromTo(files[i], folderFrom, folderTo);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Thread thread = Thread.currentThread();
            //System.out.println(thread.getName() + "(" + thread.getId() + ") " + files[i].getName());
        }
    }

    @Override
    public String toString() {
        return "ArraySum{" +
                ", startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                '}';
    }
}
