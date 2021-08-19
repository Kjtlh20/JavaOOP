/* 1) Создать класс Animal.
 * У него должны быть поля:
 * ● String ration (чем питается животное)
 * ● String color (какого оно цвета)
 * ● int weight (вес)
 *  Методы:
 * ● Стандартные (методы получения и установки, toString() и т. д.)
 * ● String getVoice() (подать голос)
 * ● void eat() (есть)
 * ● void sleep() (спать)
 * 2) Создать классы Cat, Dog как подклассы Animal. Добавьте новое поле String name. Переопределите методы
 * getVoice(), eat(), sleep().
 * 3) Создайте класс Veterinarian.
 * Поля:
 * ● String name
 * Методы:
 * ● Стандартные
 * ● void treatment(Animal animal) (Лечение животного. Лечить можно и кошек и собак)
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Animal animal = new Animal("meat", "grey", 5);
        System.out.println(animal);
        Cat cat = new Cat("meat", "grey", 5, "Kitun");
        System.out.println(cat);
        System.out.println(cat.getVoice());
        cat.eat();
        cat.sleep();
        Dog dog = new Dog("bone", "black", 10, "Pluto");
        System.out.println(dog);
        System.out.println(dog.getVoice());
        dog.eat();
        dog.sleep();
        Veterinarian veterinarian = new Veterinarian("Yarik");
        System.out.println(veterinarian);
        veterinarian.treatment(cat);
        veterinarian.treatment(dog);
    }
}
