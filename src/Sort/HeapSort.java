package Sort;

public class HeapSort {


    public static void heapSort(int[] arr) {
        int temp = 0;
        System.out.println("堆排序");
        //将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
    }

    /**
     * 将一个数组（二叉树），调整成一个大顶堆
     * 将以ｉ对应的非叶子节点的树调整成大顶堆
     * @param arr   待调整的数组
     * @param i     表示非叶子节点在数组索引
     * @param length    表示对多少个元素继续调整，length是在逐渐的减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //取出当前的元素的值，保存在临时变量
        int temp = arr[i];

        //ｋ　＝　i * 2 + 1，k是i节点的左节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            //说明左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //k指向右子节点
                k++;
            }
            //如果子节点大于父节点
            if (arr[k] > temp) {
                //把较大的值赋给当前节点
                arr[i] = arr[k];
                //i指向ｋ，继续循环比较
                i = k;
            } else {
                break;
            }
        }

        //当for循环结束后,我们已经将以父节点的树的最大值，放在了最顶（局部）
        arr[i] = temp;
    }
}
