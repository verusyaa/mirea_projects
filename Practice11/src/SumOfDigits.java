import java.util.Scanner;

public class SumOfDigits {
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Сумма цифр числа ===");
        System.out.print("Введите натуральное число N: ");
        int n = sc.nextInt();
        int result = sumDigits(n);
        System.out.println("Сумма цифр числа " + n + " = " + result);
        sc.close();
    }
}