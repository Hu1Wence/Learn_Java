package Test_1222;

public class MyBlockingQueue<E> {

    //存放数据的容器
    private Object[] elements;

    //当前可插入的索引
    private int putIndex;

    //当前获取元素的索引
    private int takeIndex;

    //当前有效元素的个数
    private int size;

    public MyBlockingQueue(int capacity) {
        elements = new Object[capacity];
    }

    public synchronized void put(E element) throws InterruptedException {
        //如果容器已满,则需要等待移除元素
        while (size == elements.length) {
            this.wait();
        }
        elements[putIndex] = element;
        //保证循环队列
        putIndex = (putIndex + 1) % elements.length;
        size++;
        this.notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        //如果容器已空,则需要等待添加元素
        while (size == 0) {
            this.wait();
        }
        E element = (E) elements[takeIndex];
        takeIndex++;
        size--;
        this.notifyAll();
        return element;
    }
}

