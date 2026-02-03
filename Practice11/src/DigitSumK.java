import java.util.Scanner;

public class DigitSumK {
    public static int countNumbers(int k, int s, int length, int sum) {
        if (length == k) return sum == s ? 1 : 0;
        int total = 0;
        for (int digit = (length == 0 ? 1 : 0); digit <= 9; digit++) {
            if (sum + digit <= s) {
                total += countNumbers(k, s, length + 1, sum + digit);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== K-значные числа с суммой цифр S ===");
        System.out.print("Введите k (количество цифр): ");
        int k = sc.nextInt();
        System.out.print("Введите s (сумма цифр): ");
        int s = sc.nextInt();
        int result = countNumbers(k, s, 0, 0);
        System.out.println("Количество " + k + "-значных чисел с суммой цифр " + s + ": " + result);
        sc.close();
    }
}
