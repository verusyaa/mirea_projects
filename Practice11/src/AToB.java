import java.util.Scanner;

public class AToB {
    public static void printRange(int a, int b) {
        System.out.print(a + " ");
        if (a == b) return;
        if (a < b) printRange(a + 1, b);
        else printRange(a - 1, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Числа от A до B ===");
        System.out.print("Введите число A: ");
        int a = sc.nextInt();
        System.out.print("Введите число B: ");
        int b = sc.nextInt();
        System.out.print("Числа от " + a + " до " + b + ": ");
        printRange(a, b);
        sc.close();
    }
}
