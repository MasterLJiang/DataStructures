package Recursion;

import java.util.Queue;

/**
 * 8皇后问题
 * @author Dark
 * @2019/7/15 8:50
 */
public class Queue8 {
    //皇后数量
    int max = 8;
    //皇后存放位置数组，res[i] = j,表示第i+1的皇后，放在第i + 1行 第j列
    int[] res = new int[max];

    static int count = 0;
    static int judgeCount = 0;

    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println(count);
        System.out.println(judgeCount);
    }

    private void check(int n) {
        //当n=8时，全部皇后已经放好
        if (n == max) {
            print();
            return;
        }

        //放入皇后位置
        for (int i = 0; i < 8; i++) {
            res[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    //判断皇后是否冲突
    private boolean judge(int n) {
        judgeCount++;
        for (int i = 0; i < n; i++) {
            if (res[i] == res[n] || Math.abs(n - i) == Math.abs(res[n] - res[i])) {
                return false;
            }
        }

        return true;
    }

    private void print(){
        count++;
        for (int i = 0; i < 8; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
