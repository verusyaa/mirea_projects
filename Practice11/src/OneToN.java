import java.util.Scanner;

public class OneToN {
    public static void printNumbers(int current, int n) {
        if (current > n) return;
        System.out.print(current + " ");
        printNumbers(current + 1, n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Числа от 1 до n ===");
        System.out.print("Введите число n: ");
        int n = sc.nextInt();
        System.out.print("Числа от 1 до " + n + ": ");
        printNumbers(1, n);
        sc.close();
    }
}
