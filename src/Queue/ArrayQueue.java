package Queue;

/**
 * @author Dark
 * @2019/7/11 8:27
 */
public class ArrayQueue {
    /*
    1、数组最大容量
    2、队列头
    3、队列尾
    4、存放队列的数据
     */
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    //添加队列元素
    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列内容满了");
        }
        rear++;
        arr[rear] = n;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列内容为空");
        }
        front++;
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列内容为空");
        }
        for (int i = 1; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d \n",i,arr[i]);
        }
    }
}
