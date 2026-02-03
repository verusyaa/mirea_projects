import java.io.*;
import java.util.Scanner;

public class FileWriterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ПРОГРАММА ДЛЯ ЗАПИСИ В ФАЙЛ ===");
        System.out.println("Введите 'exit' для завершения ввода");
        System.out.println("Введите 'clear' для очистки файла и начала заново");

        boolean append = true;
        File file = new File("user_data.txt");

        try {
            System.out.print("\nХотите очистить файл перед записью? (да/нет): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("да")) {
                append = false;
                System.out.println("Файл будет перезаписан");
            } else {
                System.out.println("Данные будут добавлены в конец файла");
            }

            System.out.println("\nНачинайте ввод текста:");

            try (FileWriter writer = new FileWriter(file, append);
                 BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

                String line;
                int lineCount = 0;

                while (true) {
                    System.out.print("> ");
                    line = scanner.nextLine();

                    if (line.equalsIgnoreCase("exit")) {
                        break;
                    }

                    if (line.equalsIgnoreCase("clear")) {
                        writer.close();
                        try (FileWriter newWriter = new FileWriter(file, false)) {
                            bufferedWriter.write("");
                        }
                        System.out.println("Файл очищен. Продолжайте ввод:");
                        continue;
                    }

                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                    lineCount++;

                    if (lineCount % 5 == 0) {
                        bufferedWriter.flush();
                        System.out.println("Автосохранение... (строк: " + lineCount + ")");
                    }
                }

                bufferedWriter.flush();
                System.out.println("\nДанные успешно сохранены в файл: " + file.getAbsolutePath());
                System.out.println("Всего строк записано: " + lineCount);

                if (file.exists()) {
                    System.out.println("Размер файла: " + file.length() + " байт");
                    System.out.println("Последнее изменение: " + new java.util.Date(file.lastModified()));
                }

            }

        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом: " + e.getMessage());
        } finally {
            scanner.close();
        }
        
        System.out.println("\n=== ЗАПИСЬ СИСТЕМНОЙ ИНФОРМАЦИИ ===");

        try (FileWriter infoWriter = new FileWriter("system_info.txt")) {
            infoWriter.write("=== СИСТЕМНАЯ ИНФОРМАЦИЯ ===\n");
            infoWriter.write("Дата и время: " + new java.util.Date() + "\n");
            infoWriter.write("Пользователь: " + System.getProperty("user.name") + "\n");
            infoWriter.write("ОС: " + System.getProperty("os.name") + "\n");
            infoWriter.write("Версия Java: " + System.getProperty("java.version") + "\n");
            infoWriter.write("============================\n");

            System.out.println("Системная информация сохранена в system_info.txt");

        } catch (IOException e) {
            System.out.println("Ошибка при записи системной информации: " + e.getMessage());
        }

        System.out.println("\nПрограмма завершена.");
    }
}
