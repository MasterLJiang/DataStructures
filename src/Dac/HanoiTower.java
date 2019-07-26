package Dac;

/**
 * 汉诺塔游戏代码实现
 * @author Dark
 * @2019/7/25 9:48
 */
public class HanoiTower {
    /**
     *
     * @param num   盘的数量
     * @param a     起始柱子
     * @param b     移动时所借助的中间柱子
     * @param c     目标柱子
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从 " + a + "->" + c);
        } else {
            //当盘子数量 大于等于2的时候，
            //先将上面的盘子移动到B
            hanoiTower(num - 1,a,c,b);
            //将最下标的盘子移动到C
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            //把B塔的盘子移动到C
            hanoiTower(num - 1,b,a,c);
        }
    }
}
