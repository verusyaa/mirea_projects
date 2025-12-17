import java.util.Scanner;

class DataProcessor {

    private String getDetails(String key) throws Exception {
        if (key == null) {
            throw new NullPointerException("Ключ не может быть null");
        }
        if (key.isEmpty()) {
            throw new Exception("Ключ не может быть пустой строкой");
        }
        return "Информация для ключа '" + key + "'";
    }

    public void printDetails(String key) throws Exception {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (NullPointerException e) {
            System.out.println("Обработана NullPointerException: " + e.getMessage());
            throw e; // Пробрасываем дальше
        }
    }

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Введите ключ (или 'exit' для выхода): ");
                String key = scanner.nextLine();

                if (key.equalsIgnoreCase("exit")) {
                    break;
                }

                printDetails(key);

            } catch (Exception e) {
                System.out.println("Исключение перехвачено в getUserInput: " + e.getClass().getSimpleName());
                System.out.println("Попробуйте снова");
            }
        }

        scanner.close();
        System.out.println("Программа завершена");
    }
}

public class ExceptionPropagation {
    public static void main(String[] args) {
        DataProcessor processor = new DataProcessor();
        processor.getUserInput();
    }
}
