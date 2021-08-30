package com.gmail.dev.surovtsev.yaroslav;

import java.util.List;

public class ASCIIArtPrinter {
    private String text;
    private int width;
    private int height;
    private List<String> asciiArt;

    public ASCIIArtPrinter() {
    }

    public ASCIIArtPrinter(String text, int width, int height, List<String> ASCIIArt) {
        this.text = text;
        this.width = width;
        this.height = height;
        this.asciiArt = ASCIIArt;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<String> getASCIIArt() {
        return asciiArt;
    }

    public void setASCIIArt(List<String> ASCIIArt) {
        this.asciiArt = ASCIIArt;
    }

    public void printText() {
        char[] charArray = text.toCharArray();
        for (int i = 0; i < height; i++) {
            String line = asciiArt.get(i);
            String resultLine = "";
            for (int j = 0; j < charArray.length; j++) {
                int index = getIndexInAlhabet(charArray[j]);
                if (charArray[j] == ' ') {
                    resultLine = resultLine + "         ".substring(0, width);
                } else {
                    resultLine = resultLine + line.substring(index * width, index * width + width);
                }
            }
            System.out.println(resultLine);
        }
    }

    private int getIndexInAlhabet(char letter) {
        int index = 26;
        char[] alhabet = "abcdefghijklmnopqrstuvwxy?".toCharArray();
        for (int i = 0; i < alhabet.length; i++) {
            if (letter == alhabet[i]) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String toString() {
        return "ASCIIArtPrinter{" +
                "text='" + text + '\'' +
                ", width=" + width +
                ", height=" + height +
                ", asciiArt=" + asciiArt +
                '}';
    }
}
