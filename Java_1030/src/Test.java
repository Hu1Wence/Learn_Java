public class Test {
    public int num = 10;
    public static void main(String[] args) {
//        System.out.println(10/0);
//        int[] arr = {1, 2, 3, 4};
//        System.out.println(arr[4]);
//        Test test = null;
//        System.out.println(test.num);
        int[] arr = {1, 2, 3};
        try {
            System.out.println("before");
            arr = null;
            System.out.println(arr[100]);
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        System.out.println("after try catch");
    }
}
