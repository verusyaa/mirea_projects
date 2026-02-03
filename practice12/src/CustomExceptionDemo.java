// Собственное исключение
class InvalidKeyException extends Exception {
    public InvalidKeyException(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {

    public String getDetails(String key) throws InvalidKeyException {
        if (key == null || key.trim().isEmpty()) {
            throw new InvalidKeyException("Ключ не может быть пустым или null");
        }
        return "Данные для ключа: " + key;
    }

    public void printMessage(String key) {
        try {
            String message = getDetails(key);
            System.out.println(message);
        } catch (InvalidKeyException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        CustomExceptionDemo demo = new CustomExceptionDemo();

        System.out.println("Тест 1 - корректный ключ:");
        demo.printMessage("valid_key");

        System.out.println("\nТест 2 - пустой ключ:");
        demo.printMessage("");

        System.out.println("\nТест 3 - null ключ:");
        demo.printMessage(null);
    }
}