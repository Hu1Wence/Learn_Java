import java.util.*;

public class Test {
    public int myAtoi(String str) {
        long res = 0;
        boolean flag = true;
        int f = -1;
        char[] c = str.toCharArray();
        for(int i = 0; i<c.length;i++) {
            if(f==-1 && (c[i]=='-' || c[i]=='+') ) {
                flag = c[i]=='-'?false:true;
                f = 1;
            }else if(Character.isDigit(c[i])) {
                res = res*10 + (c[i]-'0');
                if(res>Integer.MAX_VALUE){
                    if(!flag) return  Integer.MIN_VALUE;
                    return Integer.MAX_VALUE;
                }
                f = 1;
            }else if(c[i]>30 ){
                if(f==-1 && c[i]==' ') continue;
                break;
            }
        }
        return flag == true?(int)res:(int)-res;
    }
}

