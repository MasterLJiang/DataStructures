package linkedlist;

/**
 * @author Dark
 * @2019/7/12 9:53
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoy(5);
        circleLinkedList.showBoy();

        circleLinkedList.countBoy(1,2,5);
    }
}

//创建一个环形单链表
class CircleLinkedList {
    //创建一个firstji节点
    private Boy first = new Boy(-1);
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("num不正确");
            return;
        }

        //辅助指针
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                //构成环
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void showBoy() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }

        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号%d\n",curBoy.getNo());
            if (curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误");
            return;
        }

        //创建一个辅助指针，帮助小孩出圈
        Boy helper = first;

        while (true) {
            if (helper.getNext() == first) {
                break;
            }

            helper = helper.getNext();
        }

        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }


        while (true) {
            if (helper == first) {
                break;
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            System.out.printf("小孩%d出圈\n",first.getNo());

            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后留在圈中的小孩编号%d\n",first.getNo());
    }
}


class Boy {
    //编号
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}