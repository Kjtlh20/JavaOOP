/* 1) Существуют три корабля. На каждом из них 10 ящиков груза. Они одновременно прибыли в порт,
 * в котором только два дока. Скорость разгрузки - 1 ящик в 0.5 сек.
 * Напишите программу, которая, управляя кораблями, позволит им правильно разгрузить груз.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Dock dock = new Dock("dock1", 2);
        System.out.println(dock);

        Ship ship1 = new Ship("ship1", dock);
        Ship ship2 = new Ship("ship2", dock);
        Ship ship3 = new Ship("ship3", dock);
        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println(ship3);

        Ship[] ships = new Ship[]{ship1, ship2, ship3};
        Thread[] threads = new Thread[ships.length];
        for (int i = 0; i < ships.length; i++) {
            threads[i] = new Thread(ships[i]);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(ship1);
        System.out.println(ship2);
        System.out.println(ship3);
    }
}
