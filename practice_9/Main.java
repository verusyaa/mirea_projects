package practice_9;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 100000;
        int[] data = new int[size];
        Random rnd = new Random();

        for (int i = 0; i < size; i++) {
            data[i] = rnd.nextInt(1000000);
        }

        StopWatch sw = new StopWatch();
        sw.start();

        SelectionSorter.selectionSort(data);

        sw.finish();
        System.out.println("Затраченное время: " + sw.getElapsedTime() + " мс");
    }
}
