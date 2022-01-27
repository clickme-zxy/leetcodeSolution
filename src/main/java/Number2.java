import java.util.HashMap;
/*
* 判断回文
* 1。
* */
public class Number2 {
    public boolean isPalindrome(int x) {
        String str=Integer.toString(x);
        for(int i=0,j=str.length()-1;i<=j;i++,j--){
            if(str.charAt(i)!=str.charAt(j)) return false;
        }
        return true;
    }
}
