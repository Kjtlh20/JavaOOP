package com.gmail.dev.surovtsev.yaroslav;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TextSaver {
    private TextTransformer transformer;
    private File file;

    public TextSaver() {
    }

    public TextSaver(TextTransformer transformer, File file) {
        this.transformer = transformer;
        this.file = file;
    }

    public TextTransformer getTransformer() {
        return transformer;
    }

    public void setTransformer(TextTransformer transformer) {
        this.transformer = transformer;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void saveTextToFile(String text) {
        String newText = transformer.transform(text);
        try (PrintWriter pw = new PrintWriter(file)) {
            pw.println(newText);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "TextSaver{" +
                "transformer=" + transformer +
                ", file=" + file +
                '}';
    }
}
