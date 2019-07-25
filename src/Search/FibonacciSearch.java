package Search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;

    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }

    public static int fibonacciSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;
        int mid = 0;
        int f[] = fib();
        //获取到F[k-1]
        while (high > f[k] - 1) {
            k++;
        }


        int[] temp = Arrays.copyOf(a, f[k]);
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }

        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]){
                high = mid - 1;
                /**
                 * 全部元素 = 前面元素 + 后边元素
                 * f[k] = f[k-1] + f[k-2]
                 * 因为前面有f[k-1]个元素，
                 * 即在f[k-1]的前面继续查找k--
                 * 下次循环mid = f[k-1-1] - 1
                 */
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                k -= 2;
            } else {
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }
            }
        }
        return -1;
    }
}
