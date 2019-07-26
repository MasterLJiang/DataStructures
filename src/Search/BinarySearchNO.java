package Search;

/**
 * 二分查找法 非递归
 * @author Dark
 * @2019/7/25 9:29
 */
public class BinarySearchNO {
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        //继续查找
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                //需要向左边查找
                right = mid - 1;
            } else {
                //需要向右边查找
                left = mid + 1;
            }
        }
        return -1;
    }
}
