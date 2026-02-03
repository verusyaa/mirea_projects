import java.util.Scanner;

public class ComplexExceptionHandling {

    static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }

    public void processData(String data) {
        if (data == null) {
            throw new NullPointerException("Данные отсутствуют");
        }

        if (data.length() < 3) {
            throw new ValidationException("Данные слишком короткие (минимум 3 символа)");
        }

        if (data.contains("error")) {
            throw new RuntimeException("Обнаружено запрещенное слово 'error'");
        }

        System.out.println("Обработанные данные: " + data.toUpperCase());
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Обработка данных ===");
            System.out.print("Введите строку данных: ");
            String input = scanner.nextLine();

            processData(input);

        } catch (NullPointerException e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println("Пожалуйста, введите данные");

        } catch (ValidationException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());

        } catch (RuntimeException e) {
            System.out.println("Неожиданная ошибка: " + e.getMessage());

        } finally {
            System.out.println("Завершение обработки...");
            scanner.close();
        }
    }

    public static void main(String[] args) {
        ComplexExceptionHandling app = new ComplexExceptionHandling();
        app.run();
    }
}
