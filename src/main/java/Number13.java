import java.util.HashMap;
/*
这是一道标准的投机取巧的题目：
但是非常有趣。
由于投机取巧，所以进行了优化：大于的时候+，小于的时候-
* */
/*
* 这次的题目学到了很多东西：
* 1. 首先，一个漂亮的匿名内部内，进行hashMap的更新
* 2. 如果写i!=s.length()-1和i==s.length()-1的情况；
* */
class Number13 {
    public int romanToInt(String s) {
        int num=0;
        // 实际上写一个匿名内部类是可以的，这个代码是正确的
        HashMap<Character,Integer> hashMap=new HashMap<Character,Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        for(int i=0;i<s.length();i++){
            if(i!=s.length()-1&&hashMap.get(s.charAt(i))<hashMap.get(s.charAt(i+1))){
                num-=hashMap.get(s.charAt(i));
            }else{
                num+=hashMap.get(s.charAt(i));
            }
        }
        return num;
    }
}