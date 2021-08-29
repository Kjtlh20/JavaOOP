/* Шелдон, Леонард, Воловиц, Кутрапалли и Пенни стоят в очереди за «двойной колой».
 * Как только человек выпьет такой колы, он раздваивается и оба становятся в конец очереди,
 * чтобы выпить еще стаканчик. Напишите программу, которая выведет на экран состояние очереди в
 * зависимости от того, сколько стаканов колы выдал аппарат с чудесным напитком. Например, если было
 * выдано только два стакана, то очередь выглядит как:
 * [Volovitc,Kutrapalli,Penny,Sheldon,Sheldon,Leonard,Leonard]
 */
package com.gmail.dev.surovtsev.yaroslav;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {
        Actor actor1 = new Actor("Sheldon");
        Actor actor2 = new Actor("Leonard");
        Actor actor3 = new Actor("Volovitc");
        Actor actor4 = new Actor("Kutrapalli");
        Actor actor5 = new Actor("Penny");
        Deque<Actor> actorsQueue = new ArrayDeque<>();
        actorsQueue.addFirst(actor5);
        actorsQueue.addFirst(actor4);
        actorsQueue.addFirst(actor3);
        actorsQueue.addFirst(actor2);
        actorsQueue.addFirst(actor1);
        WonderfulCocaColaMachine wccm = new WonderfulCocaColaMachine(2, actorsQueue);
        System.out.println(wccm);
        wccm.drinkCocaCola();
        System.out.println(wccm);
    }
}
