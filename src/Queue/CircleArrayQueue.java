package Queue;

/**
 * @author Dark
 * @2019/7/11 10:29
 */
public class CircleArrayQueue {
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

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[this.maxSize];
        front = -1;
        rear = -1;
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    //添加队列元素
    public void add(int n) {
        if (isFull()) {
            throw new RuntimeException("队列内容满了");
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列内容为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列内容为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d \n",i % maxSize,arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
