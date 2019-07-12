package linkedlist;

/**
 * 头插法双链表
 * @author Dark
 * @2019/7/12 8:52
 */
public class DoubleLinkedList {
    private Node head = new Node(null);

    public void add(Object o) {
        Node node = new Node(o);
        node.next = head;
        head.pre = node;
        head = node;
    }


    public void list() {
        Node temp = head;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }

        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    //删除指定内容节点
    public void del(Object o) {
        if (head == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        Node temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.t.equals(o)) {
                flag = true;
                break;
            }
        }

        if (flag) {
            temp.pre.next = temp.next;
            temp.next.pre = temp.pre;
        }else {
            System.out.printf("要删除的%d节点不存在\n",o);
        }
    }


    //链表长度
    public int length() {
        Node temp = head.next;
        if (temp == null) {
            return 0;
        }
        int length = 0;
        while (true) {
            if (temp == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }
}

class Node <T> {
    T t;
    public Node next;
    public Node pre;

    public Node(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "[T : " + t + " ]";
    }
}

