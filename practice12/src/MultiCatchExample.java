import java.util.Scanner;

public class MultiCatchExample {

    public void process() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите число для обработки: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("qwerty")) {
                throw new IllegalArgumentException("Введено некорректное значение");
            }

            int number = Integer.parseInt(input);
            System.out.println("Результат: " + (100 / number));

        } catch (NumberFormatException e) {
            System.out.println("Ошибка преобразования числа: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Арифметическая ошибка: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Общая ошибка: " + e.getClass().getName());
        } finally {
            System.out.println("Блок finally выполнен");
            scanner.close();
        }
    }

    public static void main(String[] args) {
        MultiCatchExample example = new MultiCatchExample();
        example.process();
    }
}