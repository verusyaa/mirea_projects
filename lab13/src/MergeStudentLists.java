import java.util.ArrayList;
import java.util.List;

class MergeStudent implements Comparable<MergeStudent> {
    private String name;
    private int score;

    public MergeStudent(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(MergeStudent other) {
        return Integer.compare(this.score, other.score);
    }

    @Override
    public String toString() {
        return String.format("%s: %d баллов", name, score);
    }
}

public class MergeStudentLists {

    public static List<MergeStudent> mergeSort(List<MergeStudent> list) {
        if (list.size() <= 1) {
            return list;
        }

        int mid = list.size() / 2;
        List<MergeStudent> left = new ArrayList<>(list.subList(0, mid));
        List<MergeStudent> right = new ArrayList<>(list.subList(mid, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static List<MergeStudent> merge(List<MergeStudent> left, List<MergeStudent> right) {
        List<MergeStudent> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).compareTo(right.get(j)) <= 0) {
                result.add(left.get(i));
                i++;
            } else {
                result.add(right.get(j));
                j++;
            }
        }

        while (i < left.size()) {
            result.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            result.add(right.get(j));
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<MergeStudent> group1 = new ArrayList<>();
        group1.add(new MergeStudent("Алексей", 85));
        group1.add(new MergeStudent("Мария", 92));
        group1.add(new MergeStudent("Сергей", 78));
        group1.add(new MergeStudent("Елена", 95));

        List<MergeStudent> group2 = new ArrayList<>();
        group2.add(new MergeStudent("Дмитрий", 88));
        group2.add(new MergeStudent("Наталья", 91));
        group2.add(new MergeStudent("Павел", 82));
        group2.add(new MergeStudent("Ирина", 89));

        System.out.println("Первая группа студентов:");
        for (MergeStudent s : group1) {
            System.out.println(s);
        }

        System.out.println("\nВторая группа студентов:");
        for (MergeStudent s : group2) {
            System.out.println(s);
        }

        List<MergeStudent> allStudents = new ArrayList<>();
        allStudents.addAll(group1);
        allStudents.addAll(group2);

        List<MergeStudent> sortedStudents = mergeSort(allStudents);

        System.out.println("\nОбъединенный и отсортированный список (по баллам):");
        for (MergeStudent s : sortedStudents) {
            System.out.println(s);
        }
    }
}
