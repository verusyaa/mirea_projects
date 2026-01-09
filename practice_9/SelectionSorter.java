package practice_9;

public class SelectionSorter {
    public static void selectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[idx]) {
                    idx = j;
                }
            }
            int x = a[i];
            a[i] = a[idx];
            a[idx] = x;
        }
    }
}
