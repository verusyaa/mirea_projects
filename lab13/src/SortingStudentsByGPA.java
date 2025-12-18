import java.util.Comparator;
import java.util.Arrays;

class StudentGPA {
    private String name;
    private double gpa;

    public StudentGPA(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("%s: GPA = %.2f", name, gpa);
    }
}

class GPAComparator implements Comparator<StudentGPA> {
    @Override
    public int compare(StudentGPA s1, StudentGPA s2) {
        return Double.compare(s2.getGPA(), s1.getGPA()); // По убыванию
    }
}

public class SortingStudentsByGPA {

    public static void quickSort(StudentGPA[] students, int low, int high, Comparator<StudentGPA> comparator) {
        if (low < high) {
            int pi = partition(students, low, high, comparator);
            quickSort(students, low, pi - 1, comparator);
            quickSort(students, pi + 1, high, comparator);
        }
    }

    private static int partition(StudentGPA[] students, int low, int high, Comparator<StudentGPA> comparator) {
        StudentGPA pivot = students[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(students[j], pivot) < 0) {
                i++;
                swap(students, i, j);
            }
        }
        swap(students, i + 1, high);
        return i + 1;
    }

    private static void swap(StudentGPA[] students, int i, int j) {
        StudentGPA temp = students[i];
        students[i] = students[j];
        students[j] = temp;
    }

    public static void main(String[] args) {
        StudentGPA[] students = {
                new StudentGPA("Анна", 4.8),
                new StudentGPA("Борис", 3.5),
                new StudentGPA("Виктор", 4.2),
                new StudentGPA("Дарья", 4.9),
                new StudentGPA("Егор", 3.9),
                new StudentGPA("Ольга", 4.5),
                new StudentGPA("Михаил", 3.7)
        };

        System.out.println("Исходный список студентов:");
        for (StudentGPA s : students) {
            System.out.println(s);
        }

        GPAComparator comparator = new GPAComparator();
        quickSort(students, 0, students.length - 1, comparator);

        System.out.println("\nСписок после быстрой сортировки по GPA (по убыванию):");
        for (StudentGPA s : students) {
            System.out.println(s);
        }
    }
}
