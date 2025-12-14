import java.util.Scanner;

public class IsPrime {
    public static boolean isPrime(int n, int divisor) {
        if (divisor * divisor > n) return true;
        if (n % divisor == 0) return false;
        return isPrime(n, divisor + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Проверка числа на простоту ===");
        System.out.print("Введите натуральное число n > 1: ");
        int n = sc.nextInt();
        boolean prime = isPrime(n, 2);
        System.out.println("Число " + n + " является " + (prime ? "простым (Да)" : "составным (Нет)"));
        sc.close();
    }
}
