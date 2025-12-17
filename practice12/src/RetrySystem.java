import java.util.Scanner;

class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}

class ResourceAccessException extends Exception {
    public ResourceAccessException(String message) {
        super(message);
    }
}

public class RetrySystem {

    private boolean authenticate(String username, String password) throws AuthenticationException {
        if (username == null || password == null) {
            throw new AuthenticationException("Имя пользователя или пароль не могут быть null");
        }

        if (!username.equals("admin") || !password.equals("1234")) {
            throw new AuthenticationException("Неверные учетные данные");
        }

        return true;
    }

    private String accessResource() throws ResourceAccessException {
        double random = Math.random();

        if (random < 0.3) {
            throw new ResourceAccessException("Ресурс временно недоступен");
        }

        return "Конфиденциальные данные: секретный код X-42";
    }

    public void runSystem() {
        Scanner scanner = new Scanner(System.in);
        int attempts = 3;
        boolean authenticated = false;

        System.out.println("=== Система доступа к ресурсам ===");

        // Аутентификация с повторными попытками
        for (int i = 1; i <= attempts; i++) {
            System.out.println("\nПопытка аутентификации " + i + " из " + attempts);
            System.out.print("Имя пользователя: ");
            String username = scanner.nextLine();
            System.out.print("Пароль: ");
            String password = scanner.nextLine();

            try {
                authenticated = authenticate(username, password);
                if (authenticated) {
                    System.out.println("Аутентификация успешна!");
                    break;
                }
            } catch (AuthenticationException e) {
                System.out.println("Ошибка аутентификации: " + e.getMessage());
                if (i == attempts) {
                    System.out.println("Превышено количество попыток. Доступ запрещен.");
                    scanner.close();
                    return;
                }
            }
        }

        // Доступ к ресурсу с повторными попытками
        if (authenticated) {
            System.out.println("\n=== Доступ к ресурсу ===");

            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println("\nПопытка доступа к ресурсу " + i);
                    String data = accessResource();
                    System.out.println("Данные получены: " + data);
                    break;

                } catch (ResourceAccessException e) {
                    System.out.println("Ошибка доступа: " + e.getMessage());

                    if (i == 5) {
                        System.out.println("Не удалось получить доступ к ресурсу после 5 попыток");
                    } else {
                        System.out.println("Повторная попытка через 2 секунды...");
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ie) {
                            System.out.println("Прервано ожидание");
                        }
                    }
                }
            }
        }

        scanner.close();
        System.out.println("\n=== Работа системы завершена ===");
    }

    public static void main(String[] args) {
        RetrySystem system = new RetrySystem();
        system.runSystem();
    }
}
