public class Number14 {
    public static void main(String[] args) {
        String[] strs=new String[]{"ab","a"};
        System.out.println(longestCommonPrefix(strs));
    }
    /*
    * 纵向扫描：
    * 1. 比较每个字符串，知道相同。
    * 2. 我这种写法可能存在的问题：我当时进行j循环的时候，选取的是最小的长度，进行循坏，那么当一个最小的时候，可能会跳出循环
    * 但是对应的值没有发生更改。所以之后更改成这个样子
    * 3.还可以换一种写法
    * */
    public  static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];
        // 第一种写法
/*        String s1=strs[0];
        for(int i=1;i<strs.length;i++){
            String s2=strs[i];
            for(int j=0;j<s1.length();j++){
                if(j>=s2.length()||s1.charAt(j)!=s2.charAt(j)){
                    s1=s1.substring(0,j);
                }
            }
        }*/
        String s1=strs[0];
        for(int i=0;i<strs.length;i++){
            String s2=strs[i];
            int index=0;
            for(int j=0;j<Math.min(s1.length(),s2.length());j++){
                if(s1.charAt(j)==s2.charAt(j)){
                    index++;
                }
            }
            s1= s1.substring(0,index);
        }
        return s1;
    }
}
