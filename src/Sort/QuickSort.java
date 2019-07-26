package Sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author Dark
 * @2019/7/16 9:55
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr= {-9,78,0,23,-567,70,1,55,900,90};
        quickSort(arr,0,arr.length-1);
        System.out.println("arr=" + Arrays.toString(arr));
    }


    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        //中间值
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            //在pivot的左边查找大于等于pivot值，
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot 的左右两的值，已经全部符合左边小于pivot，右边大于pivot
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等--
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等++
            if (arr[r] == pivot) {
                l += 1;
            }
        }

        if (l == r) {
            l += 1;
            r -= 1;
        }

        if (left < r) {
            quickSort(arr,left,r);
        }

        if (right > l) {
            quickSort(arr,l,right);
        }

    }
}
