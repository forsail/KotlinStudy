package sort;

/**
 * Created by Administrator on 2018/2/28.
 */
public class SortUtil {

    public static void BubbleSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    public static void SelectionSort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = a[min];
                a[min] = a[i];
                a[i] = temp;
            }
        }
    }

    public static void InsertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int get = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > get) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = get;
        }
    }
}
