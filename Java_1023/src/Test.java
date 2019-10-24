public class Test {
    public static void main(String[] args) {
        MyString myString = new MyString();
        System.out.println(myString.equals("A", "A"));
        System.out.println(myString.compareTo("a", "A"));
        char[] ch = myString.toCharArray("abCdEfg");
        for (int i = 0 ; i < ch.length; i++) {
            System.out.print(ch[i] + " ");
        }
        System.out.println();
        String str1 = "abcdddcd";
        String str2 = "cd";
        System.out.println(myString.contains(str2,str1));
    }

}
