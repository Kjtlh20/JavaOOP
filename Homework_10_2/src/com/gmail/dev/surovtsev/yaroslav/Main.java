/* Сделать ф-ю ручного наполнения словаря и возможность его сохранения на диск.
 */
package com.gmail.dev.surovtsev.yaroslav;

public class Main {

    public static void main(String[] args) {
        DictionaryCreator dict = new DictionaryCreator();
        System.out.println(dict);
        dict.fill();
        System.out.println(dict);
        dict.saveToCSV();
    }
}
