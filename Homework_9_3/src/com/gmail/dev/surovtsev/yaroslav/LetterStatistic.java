package com.gmail.dev.surovtsev.yaroslav;

public class LetterStatistic {
    private Character letter;
    private Integer count;

    public LetterStatistic() {
    }

    public LetterStatistic(Character letter, Integer count) {
        this.letter = letter;
        this.count = count;
    }

    public Character getLetter() {
        return letter;
    }

    public void setLetter(Character letter) {
        this.letter = letter;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LetterStatistic{" +
                "letter=" + letter +
                ", count=" + count +
                '}';
    }
}
