package My_Package;

import java.util.Scanner;

public class SecondTask {
    int [] numbers;
    int sum;
    Scanner scanner = new Scanner(System.in);


    public void arrayEnter() {
        System.out.println("Введите размер массива: ");
        int arraySize = scanner.nextInt();
        numbers = new int[arraySize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }
    }

    public void findMaxMin() {
        int max = numbers[0];
        int min = numbers[0];
        int counter = 0;
        while (counter < numbers.length) {
            if (numbers[counter] > max) {
                max = numbers[counter];
            }

            if (numbers[counter] < min) {
                min = numbers[counter];
            }
            sum  += numbers[counter];
            counter++;
        }
        System.out.println("Минимальный элемент массива: " + min);
        System.out.println("Максимальный элемент массива: " + max);
    }

    public void secondRunner() {
        arrayEnter();
        findMaxMin();
    }
}
