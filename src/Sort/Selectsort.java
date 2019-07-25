<<<<<<< HEAD
package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author Dark
 * @2019/7/15 10:53
 */
public class Selectsort {
    public static void main(String[] args) {
        int[] arr = {9,6,3,2,0,-5};
        selectsort(arr);
    }

    public static void selectsort(int[] arr) {
        int min;
        int minindex;
        for (int i = 0; i < arr.length - 1; i++) {
            min = arr[i];
            minindex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minindex = j;
                }
            }

            if (minindex != i) {
                arr[minindex] = arr[i];
                arr[i] = min;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
