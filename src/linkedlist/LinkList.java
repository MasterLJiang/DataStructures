package linkedlist;

/**
 * 使用头插法的单链表，头节点永远保持最新节点的地址
 * @author Dark
 * @2019/7/12 8:26
 */
public class LinkList {
    //定义一个头节点
    private ListNode head;
    //节点位置
    private int pos = 0;

    public LinkList() {
        this.head = null;
    }

    //插入一个头节点
    public void add(int val) {
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    public void del(int val) {

    }

    public void list() {
        ListNode temp = head;
        if (temp == null) {
            System.out.println("链表为空");
            return;
        }

        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public int length() {
        ListNode temp = head;
        if (temp.next == null) {
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
