public class Test {
    public static void main(String[] args) {
//        String str = "name=zhangsan&age=18" ;
//        String[] result = str.split("&") ;
//        for (int i = 0; i < result.length; i++) {
//            String[] temp = result[i].split("=") ;
//            System.out.println(temp[0]+" = "+temp[1]);
//        }
        String str = "192.168.1.1" ;
        String[] result = str.split("\\.") ;
        for(String s: result) {
            System.out.println(s);
        }
    }
}
