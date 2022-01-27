import java.nio.charset.StandardCharsets;

/* 思路：
找到遍历开始的回文字串，并且删除
从a开始，找以a开头的最大回文，找到了删除。
难点：怎么找到以a开头的最大回文。
从后往前找，找到一个a，然后判断是否是回文，不是，继续；
* */
/*
* 案例：bbaabaaa 出现了问题
* 但是我也不清楚，怎么样才可以最简单
* 除此之外，程序一直在调试：
* 注意点1： substring会要填写开头和结尾后一位
* 注意点2： 在重复循环的过程中，实际上可以要重新定义i，i在下一个回合会发生--的动作
* */
public class Number1332 {
    public static void main(String[] args) {
        String s="bbaabaaa";
        System.out.println(removePalindromeSub(s));
    }
    public  static int removePalindromeSub(String s) {
        int number=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==s.charAt(0)){
                String decideStr=s.substring(0,i+1);
                if(isPalindromeSub(decideStr)==true){
                    number++;
                    s=s.substring(i+1,s.length());
                    i=s.length();
                    if(s.length()==0) return number;
                }
            }
        }
        return number;
    }
    public  static boolean isPalindromeSub(String s){
        for(int i=0,j=s.length()-1;i<j;i++,j--){
            if(s.charAt(i)!=s.charAt(j)) return false;
        }
        return true;
    }
}
/*妙呀
* 这道题目实际上由于只有 a和b组成 所以，最多只有两种可能，先删除a 或者先删除b。
* 也就意味着，最多是2次
*
* 所以：解题思路就变成了，能否一次删除，不行，两次删除
* */
