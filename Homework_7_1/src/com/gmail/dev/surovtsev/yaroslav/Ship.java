package com.gmail.dev.surovtsev.yaroslav;

import java.util.Arrays;

public class Ship implements Runnable {
    private String name;
    private Cargo[] cargo;
    private Dock dock;

    public Ship() {
    }

    public Ship(String name, Dock dock) {
        this.name = name;
        cargo = new Cargo[10];
        Arrays.fill(this.cargo, new Cargo());
        this.dock = dock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cargo[] getCargo() {
        return cargo;
    }

    public void setCargo(Cargo[] cargo) {
        this.cargo = cargo;
    }

    public Dock getDock() {
        return dock;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public Cargo unloadCargo() {
        Cargo result = null;
        for (int i = 0; i < cargo.length; i++) {
            if (cargo[i] != null) {
                result = cargo[i];
                cargo[i] = null;
                break;
            }
        }
        return result;
    }

    @Override
    public void run() {
        dock.unloadingCargo(this);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", cargo=" + Arrays.toString(cargo) +
                ", dock=" + dock +
                '}';
    }
}
