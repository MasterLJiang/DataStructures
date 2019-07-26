package Search;

/**
 * @author Dark
 * @2019/7/17 15:03
 */
public class SeqSearch {
    /**
     * 这里是查找第一个或者一个满足条件的值就返回
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        //线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}
