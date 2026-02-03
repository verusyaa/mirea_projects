import java.util.LinkedList;
import java.util.Scanner;

class Student {
    private String name;
    private int age;
    private double averageGrade;

    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String toString() {
        return String.format("%s, %d лет, средний балл: %.1f", name, age, averageGrade);
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Демонстрация работы с LinkedList ===");

        LinkedList<String> tasks = new LinkedList<>();

        tasks.addFirst("Подготовить отчет");
        tasks.addLast("Сходить на встречу");
        tasks.add("Закончить проект");
        tasks.add(1, "Проверить почту"); // Добавление по индексу

        System.out.println("\nСписок задач:");
        int taskNumber = 1;
        for (String task : tasks) {
            System.out.println(taskNumber + ". " + task);
            taskNumber++;
        }

        System.out.println("\n=== Работа с граничными элементами ===");
        System.out.println("Первая задача: " + tasks.getFirst());
        System.out.println("Последняя задача: " + tasks.getLast());

        // Удаление из начала и конца
        System.out.println("\nУдаляем первую задачу: " + tasks.removeFirst());
        System.out.println("Удаляем последнюю задачу: " + tasks.removeLast());

        System.out.println("Оставшиеся задачи: " + tasks);

        System.out.println("\n=== Работа с объектами Student ===");
        LinkedList<Student> students = new LinkedList<>();

        students.add(new Student("Иванов Иван", 20, 4.2));
        students.addFirst(new Student("Петрова Анна", 21, 4.8));
        students.addLast(new Student("Сидоров Петр", 19, 3.9));
        students.add(1, new Student("Козлова Мария", 22, 4.5));

        System.out.println("\nСписок студентов:");
        for (Student student : students) {
            System.out.println("- " + student);
        }

        System.out.print("\nВведите имя студента для поиска: ");
        String searchName = scanner.nextLine();

        boolean found = false;
        for (Student student : students) {
            if (student.getName().contains(searchName)) {
                System.out.println("Найден: " + student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Студент не найден");
        }

        System.out.println("\n=== Удаление студента ===");
        System.out.print("Введите индекс студента для удаления (0-" + (students.size()-1) + "): ");
        int indexToRemove = scanner.nextInt();

        if (indexToRemove >= 0 && indexToRemove < students.size()) {
            Student removedStudent = students.remove(indexToRemove);
            System.out.println("Удален студент: " + removedStudent);
        } else {
            System.out.println("Неверный индекс");
        }

        System.out.println("\n=== Проверка списка ===");
        System.out.println("Количество студентов: " + students.size());
        System.out.println("Список пустой? " + students.isEmpty());

        if (!students.isEmpty()) {
            System.out.println("Первый студент: " + students.peekFirst());
            System.out.println("Последний студент: " + students.peekLast());
        }

        System.out.println("\n=== Использование как очередь ===");
        LinkedList<String> queue = new LinkedList<>();

        queue.offer("Клиент 1");
        queue.offer("Клиент 2");
        queue.offer("Клиент 3");

        System.out.println("Очередь клиентов: " + queue);

        while (!queue.isEmpty()) {
            String client = queue.poll();
            System.out.println("Обслуживается: " + client);
            System.out.println("Оставшиеся в очереди: " + queue);
        }

        System.out.println("\n=== Использование как стек ===");
        LinkedList<String> stack = new LinkedList<>();

        stack.push("Документ 1");
        stack.push("Документ 2");
        stack.push("Документ 3");

        System.out.println("Стопка документов: " + stack);

        while (!stack.isEmpty()) {
            String document = stack.pop();
            System.out.println("Обрабатывается: " + document);
            System.out.println("Оставшиеся документы: " + stack);
        }

        scanner.close();
        System.out.println("\nДемонстрация LinkedList завершена!");
    }
}