package Hashtab;


import java.util.Objects;
import java.util.Scanner;

/**
 * 哈希表
 */
public class HashTab {
    public static void main(String[] args) {
        //创建哈希表
        Hashtab hashTab = new Hashtab(7);
        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("del: 删除雇员");
            System.out.println("exit: 退出系统");
            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入 id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Node node = new Node(id, name);
                    hashTab.add(node);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的 id");
                    id = scanner.nextInt();
                    hashTab.finNodeById(id);
                    break;
                case "del":
                    System.out.println("请输入要删除的 id");
                    id = scanner.nextInt();
                    hashTab.del(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }

    //创建Hashtab管理多条链表
    static class Hashtab {
        private NodeLinkedList[] nodeLinkedLists;
        private int size;

        public Hashtab(int size) {
            this.size = size;
            //初始化链表数组
            nodeLinkedLists = new NodeLinkedList[size];
            for (int i = 0; i < size; i++) {
                nodeLinkedLists[i] = new NodeLinkedList();
            }
        }

        public void add(Node node) {
            //根据员工的id，得到该员工给应当添加到哪条链表
            int no = hashFun(node.id);
            nodeLinkedLists[no].add(node);
        }

        //遍历所有的链表
        public void list() {
            for (int i = 0; i < size; i++) {
                nodeLinkedLists[i].list(i);
            }
        }

        public void finNodeById(int id) {
            int num = hashFun(id);
            Node node = nodeLinkedLists[num].findNodeById(id);
            if (node != null) {
                System.out.printf("在第%d条链表找到节点 id = %d \n", (num + 1), id);
            } else {
                System.out.println("没有找到该雇员");
            }
        }

        public void del(int id) {
            int num = hashFun(id);
            boolean flag = nodeLinkedLists[num].del(id);
            if (flag) {
                System.out.println("成功删除");
            } else {
                System.out.println("删除失败");
            }
        }


        public int hashFun(int id) {
            return id % size;
        }
    }

    //Node节点
    static class Node {
        public int id;
        public String name;
        //next默认为null
        public Node next;

        public Node(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
    }


    //创建 NodeLinkedList，表示链表
    static class NodeLinkedList {
        //头指针，执行第一个node,因此这链表head是指向第一个node
        private Node head;

        public void add(Node node) {
            //如果是添加第一个节点
            if (head == null) {
                head = node;
                return;
            }

            Node curnode = head;
            while (true) {
                if (curnode.next == null) {
                    break;
                }

                curnode = curnode.next;
            }

            curnode.next = node;
        }


        public void list(int no) {
            if (head == null) {
                System.out.println("第" + (no + 1) + "链表为空");
                return;
            }

            System.out.print("第" + (no + 1) + "链表为空");
            //辅助指针
            Node curnode = head;
            while (true) {
                System.out.printf(" -> id = %d name = %s \t", curnode.id, curnode.name);
                if (curnode.next == null) {
                    break;
                }
                curnode = curnode.next;
            }

            System.out.println();
        }

        public Node findNodeById(int id) {
            if (head == null) {
                System.out.println("链表为空");
                return null;
            }

            Node curnode = head;
            while (true) {
                if (curnode.id == id) {
                    break;
                }

                if (curnode.next == null) {
                    curnode = null;
                    break;
                }

                curnode = curnode.next;
            }

            return curnode;
        }

        public boolean del(int id) {
            if (head == null) {
                System.out.println("链表为空");
                return false;
            }

            Node curnode = head;
            while (true) {
                if (curnode.next.id == id) {
                    curnode.next = curnode.next.next;
                    return true;
                }
                if (curnode.next == null) {
                    return false;
                }

                curnode = curnode.next;
            }
        }
    }
}