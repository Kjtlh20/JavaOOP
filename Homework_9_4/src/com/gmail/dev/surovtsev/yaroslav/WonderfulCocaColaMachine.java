package com.gmail.dev.surovtsev.yaroslav;

import java.util.Deque;

public class WonderfulCocaColaMachine {
    private Integer numberOfGlasses;
    private Deque<Actor> actorsQueue;

    public WonderfulCocaColaMachine() {
    }

    public WonderfulCocaColaMachine(Integer numberOfGlasses, Deque<Actor> actorsQueue) {
        this.numberOfGlasses = numberOfGlasses;
        this.actorsQueue = actorsQueue;
    }

    public Integer getNumberOfGlasses() {
        return numberOfGlasses;
    }

    public void setNumberOfGlasses(Integer numberOfGlasses) {
        this.numberOfGlasses = numberOfGlasses;
    }

    public Deque<Actor> getActorsQueue() {
        return actorsQueue;
    }

    public void setActorsQueue(Deque<Actor> actorsQueue) {
        this.actorsQueue = actorsQueue;
    }

    public void drinkCocaCola() {
        for (int i = 0; i < numberOfGlasses; i++) {
            Actor actor = actorsQueue.pollFirst();
            actorsQueue.addLast(actor);
            actorsQueue.addLast(actor);
        }
    }

    @Override
    public String toString() {
        return "WonderfulCocaColaMachine{" +
                "numberOfGlasses=" + numberOfGlasses +
                ", actorsQueue=" + actorsQueue +
                '}';
    }
}
