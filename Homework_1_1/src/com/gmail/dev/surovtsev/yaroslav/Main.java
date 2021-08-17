/* Создайте пользовательский класс для описания товара (предположим, это задел для
 * интернет-магазина). В качестве свойств товара можете использовать значение цены,
 * описание, вес товара. Создайте пару экземпляров вашего класса и протестируйте их
 * работу.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        Goods goods1 = new Goods(1, "iPhone 7 Plus 256GB", "", 500.50, 0.1, "5901234123457", "MWLK2", true);
        Goods goods2 = new Goods(2, "iPhone 8 64GB", "", 400.80, 0.09, "59018764123457", "MHDH3", true);
        System.out.println(goods1);
        System.out.println(goods2);
    }
}
