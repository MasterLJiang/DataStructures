package linkedlist;

/**
 * 简单的单链表结构
 * @author Dark
 * @date 2019/3/14 22:25
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int x){
        val = x;
    }

    @Override
    public String toString() {
        return val + " ";
    }

}
