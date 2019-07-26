package Search;

/**
 * 二分查找
 * @author Dark
 * @2019/7/17 15:09
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1,8,10,89,100,124};
        int resindex = binarySearch(arr,0,arr.length - 1,-89);
        int index = BinarySearchNO.binarySearch(arr,-89);
        System.out.println(resindex);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        //向做递归
        if (findVal > midVal) {
            return binarySearch(arr,mid + 1, right, findVal);
        }else if (findVal < midVal) {
            return binarySearch(arr, left, mid - 1, findVal);
        }else {
            return mid;
        }
    }
}
