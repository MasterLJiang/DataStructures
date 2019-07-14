package Stack;

/**
 * 单链表简单实现栈
 * @author Dark
 * @2019/7/13 8:31
 */
class Node<E>{
    Node<E> next=null;
    E data;
    public Node(E data) {
        this.data=data;
    }
}
public class MyStack<E> {
    Node<E> top=null;//栈顶
    //isEmpty()，测试堆栈是否为空。
    public boolean isEmpty() {
        return top==null;
    }

    //push()入栈
    public void push(E data) {
        Node<E> newNode=new Node(data);
        newNode.next=top;
        top=newNode;
    }
    //pop()出栈， 移除堆栈顶部的对象，并作为此函数的值返回该对象。
    public E pop() {
        if(this.isEmpty()) {
            return null;
        }
        E tem=top.data;
        top=top.next;
        return tem;
    }
    //peek()查看堆栈顶部的对象，但不从堆栈中移除它。
    public E peek() {
        if(isEmpty()) {
            return null;
        }
        return top.data;
    }
}

