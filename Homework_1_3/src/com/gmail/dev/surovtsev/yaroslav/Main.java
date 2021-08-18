/* Создайте класс Phone (Телефон) одним из свойств должен быть его номер. Создайте
 * класс Network (сеть мобильного оператора). В классе Телефон должны быть описаны следующие методы:
 * Регистрация в сети мобильного оператора
 * Метод реализующий исходящий звонок. Данный метод принимает один параметр (описывающий номер мобильного телефона).
 * Логика работы этого метода такова: если текущий телефон не прошел регистрацию в сети, то закончить работу метода с
 * сообщением об этом. Если текущий телефон прошел регистрацию и в сети также зарегистрирован телефон на номер которого
 * совершается вызов, то вызвать метод входящий звонок у того телефона. Если телефон на номер которого вы совершаете
 * вызов в сети не зарегистрирован, то закончить работу метода с сообщением об этом.
 * Метод реализующий входящий звонок. Принимает параметр в виде номера с которого произвели вызов на текущий.
 * Вывести сообщение вида вам звонит номер такой то.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Network network = new Network("Kyivstar");
        System.out.println(network);
        Phone phone1 = new Phone("iPhone 7 Plus 256GB", "Apple", "380971111111");
        System.out.println(phone1);
        Phone phone2 = new Phone("Google Pixel 5 128GB", "Google", "380972222222");
        System.out.println(phone2);
        String phoneNumber1 = phone1.getNumber();
        String phoneNumber2 = phone2.getNumber();
        phone1.callTo(phoneNumber2);
        phone1.registerInNetwork(network);
        phone1.callTo(phoneNumber2);
        phone2.registerInNetwork(network);
        phone1.callTo(phoneNumber2);
        phone2.callTo(phoneNumber1);
    }
}
