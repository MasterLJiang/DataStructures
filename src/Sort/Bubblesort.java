package Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author Dark
 * @2019/7/15 10:18
 */
public class Bubblesort {
    public static void main(String[] args) {
        int[] arr = {0, 3, -1, 2, 1};
        System.out.println("原始数组");
        System.out.println(Arrays.toString(arr));
        System.out.println("排序后");
        System.out.println(Arrays.toString(bubblesort(arr)));
    }

    public static int[] bubblesort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }

        return arr;
    }
}
