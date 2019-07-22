package Sort;

import java.util.Arrays;

/**
 * @author Dark
 * @2019/7/16 8:40
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {10, -2, 0, 94, -99};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i - 1;
            while (index >= 0 && temp < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }

            if (index != i) {
                arr[index + 1] = temp;
            }
        }
    }
}
