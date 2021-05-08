package com.barisdere.datastructures.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        // elementler ekle
        list.add("Ankara");
        list.add("Adana");
        list.add("Van");
        list.add("Trabzon");

        // tüm içeriği ekrana yaz
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // using for
        for (String item: list) {
            System.out.println(item);
        }

        list.addFirst("Istanbul");   // en başa İstanbul ekle
        list.addLast("Bursa");       // en sona Bursa ekle

        list.removeFirst();  // baştaki elementi sil
        list.removeLast();   // sondaki elementi sil

        list.get(3);         // üçüncü elementi al
        list.getFirst();     // baştaki elementi al
        list.getLast();      // sondaki elementi al

    }
}
