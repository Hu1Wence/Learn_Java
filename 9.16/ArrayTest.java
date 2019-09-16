import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        //1.数组转字符串
        int[] arr = {10, 9, 7, 8, 4, 5, 53, 6, 7, 4};
        //Java 已经实现好的
        //String newArray = Arrays.toString(arr);
        System.out.println(myToString(arr));
        //2.数组拷贝
        int[] newArray = Arrays.copyOf(arr, arr.length);
        //Java 已经实现好的
        //System.out.println("newArray = " + Arrays.toString(newArray));
        // System.out.println("newArray = " + Arrays.toString(newArray));
        // System.out.println("arr = " + Arrays.toString(arr));
        int[] ret = myArrayCopy(arr);
        System.out.println("newArray = " + Arrays.toString(myArrayCopy(ret)));
        ret[0] = 9;
        System.out.println("arr = " + Arrays.toString(arr));
        System.out.println("newArray = " + Arrays.toString(myArrayCopy(ret)));
        //3.找数组中的最大元素
        System.out.println(max(arr));
        //4.求数组中元素的平均值
        System.out.println(avg(arr));
        //5.查找数组中指定元素(顺序查找)(如果存在，返回这个数字在数组中的下标，没找到返回-1)
        int tofind = 10;
        int result = find(arr, tofind);
        System.out.println(result);
        //6.查找数组中指定元素(二分查找)(如果存在，返回这个数字在数组中的下标，没找到返回-1)
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(arr1, tofind));
        //7.检查数组的有序性
        //检查数组是否有序(升序)
        int[] arr3 = {1, 2, 3, 5, 4, 6, 7, 8};
        System.out.println(isSorted(arr3));
        //8.冒泡排序(升序)
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        //9.数组逆序
        reverse(arr);
        System.out.println(Arrays.toString(arr));
        //10.数组数字排列
        //将所有偶数放在前半部分，技术放在后半部分
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static String myToString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i != arr.length - 1) {
                ret += ",";
            }
        }
        ret += "]";
        return ret;
    }
    public static int[] myArrayCopy(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
    public static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    public static double avg(int[] arr) {
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            avg += arr[i];
        }
        avg /= arr.length;
        return avg;
    }
    public static int find(int[] arr, int tofind) {
        int i = 0;
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == tofind) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(int[] arr1, int tofind) {
        int left = 0;
        int right = arr1.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (tofind < arr1[mid]) {
                //去左侧查找
                right = mid - 1;
            } else if (tofind > arr1[mid]) {
                //去右侧查找
                left = mid + 1;
            } else {
                //相等，说明找到了
                return mid;
            }
        }
        return -1;
    }
    public static boolean isSorted(int[] arr3) {
        for (int i = 0; i < arr3.length - 1; i++) {
            if (arr3[i] > arr3[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public static void bubbleSort(int[] arr) {
        int bound = 0;
        int cur = arr.length - 1;
        for (bound = 0; bound < arr.length - 1; bound++) {
            for (cur = arr.length - 1; cur > bound; cur--) {
                if (arr[cur - 1] > arr[cur]) {
                    int temp = arr[cur - 1];
                    arr[cur - 1] = arr[cur];
                    arr[cur] = temp;
                }
            }
        }
    }
    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
    public static void transform(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            //该循环结束，left 就指向了一个奇数
            while (left < right && arr[left] % 2 == 0) {
                left++;
            }
            //该循环结束， right 就指向了一个偶数
            while (left < right && arr[right] % 2 != 0) {
                right--;
            }
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }
    }
}