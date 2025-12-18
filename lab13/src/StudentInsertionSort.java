import java.util.Arrays;

class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, GPA: %.2f", id, name, gpa);
    }
}

public class StudentInsertionSort {

    public static void insertionSort(Student[] students) {
        for (int i = 1; i < students.length; i++) {
            Student current = students[i];
            int j = i - 1;

            while (j >= 0 && students[j].compareTo(current) > 0) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student(105, "Иванов", 4.2),
                new Student(102, "Петров", 3.8),
                new Student(107, "Сидоров", 4.5),
                new Student(101, "Козлов", 3.9),
                new Student(104, "Смирнов", 4.1),
                new Student(103, "Васильев", 3.7),
                new Student(106, "Николаев", 4.3)
        };

        System.out.println("Исходный массив студентов:");
        for (Student s : students) {
            System.out.println(s);
        }

        insertionSort(students);

        System.out.println("\nМассив после сортировки вставками по ID:");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}