package Test;

import linkedlist.DoubleLinkedList;
import linkedlist.LinkList;
import linkedlist.ListNode;

/**
 * @author Dark
 * @2019/7/12 8:33
 */


public class Test {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        doubleLinkedList.list();
        System.out.println("删除后");
        doubleLinkedList.del(2);
        doubleLinkedList.list();
    }
}
