package com.gmail.dev.surovtsev.yaroslav;

public class Veterinarian {
    private String name;

    public Veterinarian() {
    }

    public Veterinarian(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void treatment(Animal animal) {
        String className = animal.getClass().getSimpleName();
        if (className.equals("Cat")) {
            Cat cat = (Cat) animal;
            System.out.println(name + " treats a " + cat.getName());
        } else if (className.equals("Dog")) {
            Dog dog = (Dog) animal;
            System.out.println(name + " treats a " + dog.getName());
        }
    }

    @Override
    public String toString() {
        return "Veterinarian{" +
                "name='" + name + '\'' +
                '}';
    }
}
