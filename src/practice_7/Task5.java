package practice_7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task5 {

    public static void main(String[] args) {

        int n = 20000;

        List<Integer> arrayList = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) arrayList.add(i);
        long timeArrayAdd = System.nanoTime() - start;

        List<Integer> linkedList = new LinkedList<>();
        start = System.nanoTime();
        for (int i = 0; i < n; i++) linkedList.add(i);
        long timeLinkedAdd = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.add(0, 999);
        long timeArrayInsert = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.add(0, 999);
        long timeLinkedInsert = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.remove(arrayList.size() / 2);
        long timeArrayRemove = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.remove(linkedList.size() / 2);
        long timeLinkedRemove = System.nanoTime() - start;

        start = System.nanoTime();
        arrayList.contains(15000);
        long timeArraySearch = System.nanoTime() - start;

        start = System.nanoTime();
        linkedList.contains(15000);
        long timeLinkedSearch = System.nanoTime() - start;

        System.out.println("Результаты: ");
        System.out.println("Добавление ArrayList: " + timeArrayAdd);
        System.out.println("Добавление LinkedList: " + timeLinkedAdd);
        System.out.println("Вставка ArrayList: " + timeArrayInsert);
        System.out.println("Вставка LinkedList: " + timeLinkedInsert);
        System.out.println("Удаление ArrayList: " + timeArrayRemove);
        System.out.println("Удаление LinkedList: " + timeLinkedRemove);
        System.out.println("Поиск ArrayList: " + timeArraySearch);
        System.out.println("Поиск LinkedList: " + timeLinkedSearch);
    }
}
