package Sparsearray;

/**
 * @author Dark
 * @2019/7/11 8:01
 */
public class Sparsearray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11 * 11
        //0：表示没有棋子，1表示黑子 2 表示白子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //1、记录原始数组中非零元素的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //2、创建稀疏数组
        int SparseArray[][] = new int[sum + 1][3];
        //初始化
        SparseArray[0][0] = chessArr1.length;
        SparseArray[0][1] = chessArr1[0].length;
        SparseArray[0][2] = sum;

        //遍历原始数组 将非0值存入
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[0].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    SparseArray[count][0] = i;
                    SparseArray[count][1] = j;
                    SparseArray[count][2] = chessArr1[i][j];
                }
            }
        }

        //打印稀疏数组
        System.out.println("稀疏数组：");
        for (int i = 0; i < SparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",SparseArray[i][0],SparseArray[i][1],SparseArray[i][2]);
        }
        System.out.println();

        //恢复原始数组

        int[][] chessArr2 = new int[SparseArray[0][0]][SparseArray[0][1]];
        for (int i = 1; i < SparseArray.length; i++) {
            chessArr2[SparseArray[i][0]][SparseArray[i][1]] = SparseArray[i][2];
        }

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }
}
