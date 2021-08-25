package com.gmail.dev.surovtsev.yaroslav;

public class Dock {
    private String name;
    private int capacity;
    private int shipCount;

    public Dock() {
    }

    public Dock(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public synchronized void unloadingCargo(Ship ship) {
        for (; this.shipCount >= capacity; ) {
            try {
                System.out.println(ship.getName() + " wait");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        shipCount = shipCount + 1;
        for (int i = 0; i < ship.getCargo().length; i++) {
            ship.unloadCargo();
            System.out.println(ship.getName() + " unload cargo " + (i + 1));
            try {
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(ship.getName() + " is empty");
        shipCount = shipCount - 1;
        notifyAll();
    }

    @Override
    public String toString() {
        return "Dock{" +
                "name='" + name + '\'' +
                '}';
    }
}
