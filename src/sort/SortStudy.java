package sort;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/2/28.
 */
public class SortStudy {
    public static void main(String[] args) {
        int[] a = {1, 3, 3, 4, 2, 3, 7, 6, 9, 1, 2};
        SortUtil.InsertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

        Arrays.sort(a);
    }
}
