package com.gmail.dev.surovtsev.yaroslav;

public class Cat extends Animal {
    private String name;

    public Cat() {
        super();
    }

    public Cat(String ration, String color, int weight, String name) {
        super(ration, color, weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getVoice() {
        return name + " says meow-meow!!!";
    }

    @Override
    public void eat() {
        System.out.println(name + " eats " + ration);
    }

    @Override
    public void sleep() {
        System.out.println(name + " sleep Zzzzz");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }
}
