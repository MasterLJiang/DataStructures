package Stack;

/**
 * 数组实现栈
 * @author Dark
 * @2019/7/13 8:14
 */
public class ArrayStack {
}

class ArraysStack{
    private int maxsize;
    private int[] stack;
    private int top = -1;

    public ArraysStack(int maxsize) {
        this.maxsize = maxsize;
        stack = new int[this.maxsize];
    }

    public boolean ifFull() {
        return top == maxsize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int val) {
        if (ifFull()) {
            System.out.println("栈满");
            return;
        }

        top++;
        stack[top] = val;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }

        int value = stack[top];
        top--;
        return value;
    }

    public int peek() {
        return stack[top];
    }

    public void list() {
        if (isEmpty()) {
            throw new RuntimeException("栈空");
        }
        for (int i = top; i > 0; i--) {
            System.out.printf("stack[%d] = %d",i,stack[i]);
        }
    }
}
