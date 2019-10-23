public class MyString {

    public boolean equals(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                return false;
            }
        }
        return true;
    }

    public int compareTo(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        return ch1[0] - ch2[0];
    }

    public char[] toCharArray(String str) {
        char[] ch = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }
        return ch;
    }

//    public boolean contains(String target, String source) {
//
//    }
//
//    public int indexOf(String target, String source) {
//
//    }
//    public int  lastIndexOf(String target, String source) {
//
//    }

    public String replaceAll(String target, String source, String replace) {
        char tar = target.charAt(0);
        char[] sour = source.toCharArray();
        for (int i = 0; i < sour.length; i++) {
            if (sour[i] == tar) {
                sour[i] = replace.charAt(0);
            }
        }
        return new String(sour);
    }
}

