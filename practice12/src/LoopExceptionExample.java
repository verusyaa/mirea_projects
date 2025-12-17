import java.util.Scanner;
import java.util.Random;

public class LoopExceptionExample {

    public void demonstrate() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Демонстрация обработки исключений в цикле");
        System.out.println("Введите количество итераций (1-10): ");

        int iterations = 0;

        try {
            iterations = scanner.nextInt();
            if (iterations < 1 || iterations > 10) {
                throw new IllegalArgumentException("Количество должно быть от 1 до 10");
            }
        } catch (Exception e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
            iterations = 5; // значение по умолчанию
        }

        for (int i = 1; i <= iterations; i++) {
            System.out.println("\n--- Итерация " + i + " ---");

            try {
                int operation = random.nextInt(4);

                switch (operation) {
                    case 0:
                        // Деление на ноль
                        System.out.println("Операция: деление на ноль");
                        int result = 10 / (i - 1); // На первой итерации будет деление на 0
                        break;

                    case 1:
                        // Выход за границы массива
                        System.out.println("Операция: работа с массивом");
                        int[] array = new int[3];
                        array[5] = 10;
                        break;

                    case 2:
                        // Преобразование строки
                        System.out.println("Операция: преобразование строки");
                        String invalid = "abc";
                        int num = Integer.parseInt(invalid);
                        break;

                    case 3:
                        // Нормальная операция
                        System.out.println("Операция: нормальное вычисление");
                        System.out.println("Результат: " + (i * 10));
                        break;
                }

            } catch (ArithmeticException e) {
                System.out.println("Перехвачено ArithmeticException: " + e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Перехвачено ArrayIndexOutOfBoundsException");
            } catch (NumberFormatException e) {
                System.out.println("Перехвачено NumberFormatException");
            } catch (Exception e) {
                System.out.println("Перехвачено общее исключение: " + e.getClass().getSimpleName());
            }
        }

        scanner.close();
        System.out.println("\nПрограмма завершена успешно");
    }

    public static void main(String[] args) {
        LoopExceptionExample example = new LoopExceptionExample();
        example.demonstrate();
    }
}