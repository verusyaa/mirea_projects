import java.util.Scanner;
import java.util.InputMismatchException;

public class InputHandler {

    public void processInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите целое число: ");

        try {
            int number = scanner.nextInt();
            int result = 100 / number;
            System.out.println("Результат 100 / " + number + " = " + result);

        } catch (ArithmeticException e) {
            System.out.println("Ошибка: деление на ноль невозможно");
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число");
        } finally {
            System.out.println("Операция ввода завершена");
            scanner.close();
        }
    }

    public static void main(String[] args) {
        InputHandler handler = new InputHandler();
        handler.processInput();
    }
}
