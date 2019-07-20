package Test;

import Search.InsertValueSearch;

/**
 * @author Dark
 * @2019/7/12 8:33
 */


public class Test {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }
        int index = InsertValueSearch.insertValueSearch(arr, 0, arr.length - 1, 1);
        System.out.println(index);
    }
}
