package linkedlist;

/**
 * @author Dark
 * @2019/7/11 10:44
 */
public class SingleLinkedList{
    private HeroNode head = new HeroNode(0,"","");

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }

    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表
            if (temp == null) {
                break;
            }

            System.out.println(temp);
            temp = temp.next;
        }
    }
}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode [no = " + no + " , name = " + name + " , nickname = " + nickname + " ]";
    }
}
