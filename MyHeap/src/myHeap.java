import java.util.Arrays;

public class myHeap {

    public static void shiftDown(int[] array, int size, int index) {
        int parent = index;
        int child = parent * 2 + 1;
        while (child < size) {
            if (child + 1 < size && array[child + 1] > array[child]) {
                child = child + 1;
            }
            //到这里不管上面条件满足没满足
            // array[child] 都会指向那个较大的子节点值

            if (array[parent] < array[child]) {
                //如果条件成立，说明不满足大堆的条件
                //然后交换
                swap(array, child, parent);
            } else {
                break;
            }
            //更新parent 和 child 的值
            parent = child;
            child = parent * 2 + 1;
        }
    }

    public static void swap(int[] array, int x, int y) {
       int tmp = array[x];
       array[x] = array[y];
       array[y] = tmp;
    }

    // 要把 [0, size) 范围中的元素建成堆
    public static void createHeap(int[] array, int size) {
        for (int i = (size - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(array, size, i);
        }
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        createHeap(array, array.length);
        System.out.println(Arrays.toString(array));
    }
}
