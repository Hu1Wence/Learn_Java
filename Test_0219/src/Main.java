import java.util.Arrays;

public class Main {

    //插入排序
    public static void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (array[j] > temp) {
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    //选择排序
    public static void selectSort(int[] array) {

        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]) {
                    int temp = array[cur];
                    array[cur] = array[bound];
                    array[bound] = temp;
                }
            }
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] array) {
        for (int bound = 0; bound < array.length; bound++){
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur] < array[cur - 1]) {
                    int temp = array[cur];
                    array[cur] = array[cur - 1];
                    array[cur - 1] = temp;
                }
            }
        }
    }

    //快速排序


    public static void main(String[] args) {

        int[] array = new int[]{9, 5, 5, 2, 7, 1, 3, 8};

//        insertSort(array);
//        selectSort(array);
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


}
