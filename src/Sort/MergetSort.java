package Sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author Dark
 * @2019/7/17 9:30
 */
public class MergetSort {
    public static void main(String[] args) {
        int[] arr = {6,5,9,0,-1,-9,8,10};
        int[] temp = new int[arr.length];
        mergeSort(arr,0,arr.length - 1,temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right,int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向做递归进行分解
            mergeSort(arr,left,mid,temp);
            mergeSort(arr,mid+1,right,temp);
            merge(arr, left, mid, right,temp);
        }
    }

    /**
     *
     * @param arr arr 排序出初始数组
     * @param left  left 左边有序序列的的初始化索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  temp中转数组
     */
    public static void merge(int[] arr, int left,int mid, int right,int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        while (i <= mid && j <= right) {
            //如果左边的有序序列的当前元素，小于等于右边有序序列的当前元素
            //即左边的当前元素，填充到temp数组
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {//反之，将右边有序序列的当前元素，填充到temp数组
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }

        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }

        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int templeft = left;
        while (templeft <= right) {
            arr[templeft] = temp[t];
            templeft += 1;
            t += 1;
        }
    }
}
