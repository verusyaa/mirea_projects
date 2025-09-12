package My_Package;

import java.util.Scanner;

public class FifthTask {
    Scanner scanner = new Scanner(System.in);

    public void fifthRunner() {
        System.out.println("Введите число, факториал которого вы хотите найти: ");
        int number =  scanner.nextInt();

        int result = findFactorial(number);
        System.out.println("Факториал вашего числа: " + result);

    }

    public int findFactorial(int number) {
        if (number < 0){
            System.out.println("Найти факториал невозможно");
            return 0;
        }

        int result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
