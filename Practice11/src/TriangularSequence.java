import java.util.Scanner;

public class TriangularSequence {
    public static void printSequence(int current, int count, int n) {
        if (n == 0) return;
        System.out.print(current + " ");
        if (count == current) {
            printSequence(current + 1, 1, n - 1);
        } else {
            printSequence(current, count + 1, n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Треугольная последовательность ===");
        System.out.println("Каждое число k встречается ровно k раз: 1, 2, 2, 3, 3, 3, ...");
        System.out.print("Введите n (сколько членов последовательности вывести): ");
        int n = sc.nextInt();
        System.out.print("Первые " + n + " членов последовательности: ");
        printSequence(1, 1, n);
        sc.close();
    }
}
