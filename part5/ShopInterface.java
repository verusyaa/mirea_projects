package lab5.part5;

import java.util.List;
import java.util.Scanner;

public class ShopInterface {
    private Shop shop;
    private Scanner scanner;

    public ShopInterface(Shop shop) {
        this.shop = shop;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Добро пожаловать в интернет-магазин компьютерной техники! ===");

        while (true) {
            printMenu();
            int choice = getIntInput("Выберите действие: ");

            switch (choice) {
                case 1 -> addComputer();
                case 2 -> removeComputer();
                case 3 -> searchComputers();
                case 4 -> showAllComputers();
                case 5 -> {
                    System.out.println("До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== МЕНЮ ===");
        System.out.println("1. Добавить компьютер");
        System.out.println("2. Удалить компьютер");
        System.out.println("3. Поиск компьютеров");
        System.out.println("4. Показать все компьютеры");
        System.out.println("5. Выход");
    }

    private void addComputer() {
        System.out.println("\n=== ДОБАВЛЕНИЕ НОВОГО КОМПЬЮТЕРА ===");

        ComputerBrand brand = selectComputerBrand();
        System.out.print("Введите модель: ");
        String model = scanner.nextLine();
        double price = getDoubleInput("Введите цену: ");

        System.out.println("\n--- Процессор ---");
        ProcessorBrand procBrand = selectProcessorBrand();
        System.out.print("Введите модель процессора: ");
        String procModel = scanner.nextLine();
        double frequency = getDoubleInput("Введите частоту (GHz): ");
        int cores = getIntInput("Введите количество ядер: ");
        Processor processor = new Processor(procBrand, procModel, frequency, cores);

        System.out.println("\n--- Память ---");
        MemoryBrand memBrand = selectMemoryBrand();
        System.out.print("Введите тип памяти (DDR4/DDR5): ");
        String memType = scanner.nextLine();
        int memSize = getIntInput("Введите объем памяти (GB): ");
        int memFreq = getIntInput("Введите частоту памяти (MHz): ");
        Memory memory = new Memory(memBrand, memType, memSize, memFreq);

        System.out.println("\n--- Монитор ---");
        MonitorBrand monBrand = selectMonitorBrand();
        System.out.print("Введите модель монитора: ");
        String monModel = scanner.nextLine();
        double monSize = getDoubleInput("Введите размер монитора (дюймы): ");
        System.out.print("Введите разрешение (например, 1920x1080): ");
        String resolution = scanner.nextLine();
        Monitor monitor = new Monitor(monBrand, monModel, monSize, resolution);

        Computer computer = new Computer(brand, model, processor, memory, monitor, price);
        if (shop.addComputer(computer)) {
            System.out.println("\n✅ Компьютер успешно добавлен в магазин!");
        } else {
            System.out.println("\n❌ Ошибка при добавлении компьютера!");
        }
    }

    private void removeComputer() {
        System.out.println("\n=== УДАЛЕНИЕ КОМПЬЮТЕРА ===");
        showAllComputers();

        if (shop.getComputerCount() == 0) {
            return;
        }

        int index = getIntInput("Введите номер компьютера для удаления: ") - 1;
        if (shop.removeComputer(index)) {
            System.out.println("✅ Компьютер успешно удален!");
        } else {
            System.out.println("❌ Неверный номер компьютера!");
        }
    }

    private void searchComputers() {
        System.out.println("\n=== ПОИСК КОМПЬЮТЕРОВ ===");
        System.out.println("1. Поиск по бренду");
        System.out.println("2. Поиск по цене");
        System.out.println("3. Поиск по процессору");
        System.out.println("4. Поиск по объему памяти");
        System.out.println("5. Расширенный поиск");

        int choice = getIntInput("Выберите тип поиска: ");
        List<Computer> results;

        switch (choice) {
            case 1 -> {
                ComputerBrand brand = selectComputerBrand();
                results = shop.findComputersByBrand(brand);
            }
            case 2 -> {
                double minPrice = getDoubleInput("Минимальная цена: ");
                double maxPrice = getDoubleInput("Максимальная цена: ");
                results = shop.findComputersByPrice(minPrice, maxPrice);
            }
            case 3 -> {
                ProcessorBrand procBrand = selectProcessorBrand();
                results = shop.findComputersByProcessor(procBrand);
            }
            case 4 -> {
                int minMemory = getIntInput("Минимальный объем памяти (GB): ");
                results = shop.findComputersByMemorySize(minMemory);
            }
            case 5 -> {
                System.out.println("Оставьте поле пустым, если параметр не важен");
                ComputerBrand brand = selectComputerBrandOptional();
                Double minPrice = getDoubleInputOptional("Минимальная цена: ");
                Double maxPrice = getDoubleInputOptional("Максимальная цена: ");
                ProcessorBrand procBrand = selectProcessorBrandOptional();
                Integer minMemory = getIntInputOptional("Минимальный объем памяти (GB): ");

                results = shop.searchComputers(brand, minPrice, maxPrice, procBrand, minMemory);
            }
            default -> {
                System.out.println("Неверный выбор!");
                return;
            }
        }

        displaySearchResults(results);
    }

    private void showAllComputers() {
        System.out.println("\n=== ВСЕ КОМПЬЮТЕРЫ В МАГАЗИНЕ ===");
        List<Computer> computers = shop.getAllComputers();

        if (computers.isEmpty()) {
            System.out.println("Магазин пуст!");
            return;
        }

        for (int i = 0; i < computers.size(); i++) {
            System.out.println((i + 1) + ". " + computers.get(i).toShortString());
        }
    }

    private void displaySearchResults(List<Computer> results) {
        if (results.isEmpty()) {
            System.out.println("\n❌ Компьютеры по заданным критериям не найдены!");
            return;
        }

        System.out.println("\n✅ Найдено компьютеров: " + results.size());
        for (int i = 0; i < results.size(); i++) {
            System.out.println("\n--- Результат " + (i + 1) + " ---");
            System.out.println(results.get(i));
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    private Integer getIntInputOptional(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input.isEmpty() ? null : Integer.parseInt(input);
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }

    private Double getDoubleInputOptional(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine();
        return input.isEmpty() ? null : Double.parseDouble(input);
    }

    private ComputerBrand selectComputerBrand() {
        return selectFromEnum(ComputerBrand.values(), "бренд компьютера");
    }

    private ComputerBrand selectComputerBrandOptional() {
        return selectFromEnumOptional(ComputerBrand.values(), "бренд компьютера");
    }

    private ProcessorBrand selectProcessorBrand() {
        return selectFromEnum(ProcessorBrand.values(), "бренд процессора");
    }

    private ProcessorBrand selectProcessorBrandOptional() {
        return selectFromEnumOptional(ProcessorBrand.values(), "бренд процессора");
    }

    private MemoryBrand selectMemoryBrand() {
        return selectFromEnum(MemoryBrand.values(), "бренд памяти");
    }

    private MonitorBrand selectMonitorBrand() {
        return selectFromEnum(MonitorBrand.values(), "бренд монитора");
    }

    private <T extends Enum<T>> T selectFromEnum(T[] values, String typeName) {
        System.out.println("\nВыберите " + typeName + ":");
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }

        while (true) {
            int choice = getIntInput("Ваш выбор (1-" + values.length + "): ") - 1;
            if (choice >= 0 && choice < values.length) {
                return values[choice];
            }
            System.out.println("Неверный выбор! Попробуйте снова.");
        }
    }

    private <T extends Enum<T>> T selectFromEnumOptional(T[] values, String typeName) {
        System.out.println("\nВыберите " + typeName + " (Enter чтобы пропустить):");
        System.out.println("0. Пропустить");
        for (int i = 0; i < values.length; i++) {
            System.out.println((i + 1) + ". " + values[i]);
        }

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                return null;
            }

            try {
                int choice = Integer.parseInt(input) - 1;
                if (choice >= -1 && choice < values.length) {
                    return choice == -1 ? null : values[choice];
                }
            } catch (NumberFormatException e) {
                // Продолжаем цикл
            }
            System.out.println("Неверный выбор! Попробуйте снова.");
        }
    }
}
