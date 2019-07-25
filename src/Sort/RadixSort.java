<<<<<<< HEAD
package Sort;

/**
 * 基数排序
 * @author Dark
 * @2019/7/17 14:44
 */
public class RadixSort {
    public static void radixSort(int[] arr) {
        //得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                max = arr[i];
            }
        }

        int maxLength = (max + "").length();

        /**
         * 定义一个二维数组 bucket[][] , bucket[i][j] i 表示桶下标，j表示桶中元素数量
         *
         */
        int[][] bucket = new int[10][arr.length];

        //记录每个桶中，实际存放了多少个元素，定义一个一维数组来记录每个桶的每次存放的数据个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++,n *= 10) {
            for (int  j = 0; j < arr.length; j++) {
                int digitOfElement = arr[j] / n % 10;
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }

            int index = 0;

            //遍历每一桶，并将桶中的数据，放入原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中，有数据，我们才放入到原数组
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }
}
