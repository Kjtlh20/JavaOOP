/* Создайте класс-контейнер типа стек (класс в который можно добавлять и удалять объекты других классов,
 * только в вершину стека), в который можно сохранять объекты произвольного типа. Создайте стек на основе массива Object.
 * Реализуйте методы:
 * public void push(Object obj) добавления элемента в стек
 * public Object pop() получение с удалением элемента из вершины стека
 * public Object peek() получение элемента с вершины стека без удаления.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        Cat[] cats = new Cat[6];
        for (int i = 0; i < cats.length; i++) {
            cats[i] = new Cat("Cat" + (i + 1));
        }
        for (int i = 0; i < cats.length; i++) {
            try {
                stack.push(cats[i]);
            } catch (StackOverflowException e) {
                e.printStackTrace();
            }
            System.out.println("push: " + cats[i]);
        }
        System.out.println(stack);
        Object cat = null;
        try {
            cat = stack.pop();
        } catch (StackEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("pop: " + cat);
        System.out.println(stack);
        try {
            cat = stack.peek();
        } catch (StackEmptyException e) {
            e.printStackTrace();
        }
        System.out.println("peek: " + cat);
        System.out.println(stack);
    }
}
