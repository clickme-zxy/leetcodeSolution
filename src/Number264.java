import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Number264 {
    //  方法一：利用队列（小根堆）。将数据放入队列中，如果不重复，则加入。取出丑数 *2 *3 *5s
    // 时间复杂度O(n*logn)（一次操作logn,小根堆） 空间复杂度O(n)
    public int nthUglyNumber1(int n) {
        int [] nums=new int[]{2,3,5};
        PriorityQueue<Long> priorityQueue=new PriorityQueue<>();
        Set<Long> set=new HashSet<>();
        int number=0;
        priorityQueue.add(1L);
        set.add(1L);
        while(!priorityQueue.isEmpty()){
            long x=priorityQueue.poll();
            n--;
            if(n==0) return (int)x;
            for(int num:nums){
                if(!set.contains(x*num)){
                    priorityQueue.add(x*num);
                    set.add(x*num);
                }
            }
        }
        return -1;
    }
    /*方法2：归并算法。
    2: arr*2
    3: arr*3
    4: arr*4
    依次，可以计算出arr的后一位，所以，取三个数中的最小值；然后就可以；
    * */
    public int nthUglyNumber2(int n) {
        int [] number=new int[n+1];
        number[1]=1;
        for(int a1=1,b1=1,c1=1,i=2;i<=n;i++){
            int a=number[a1]*2;
            int b=number[b1]*3;
            int c=number[c1]*5;
            int min=Math.min(Math.min(a,b),c);
            number[i]=min;
            // 由于存在相同的丑数，所以不能用else if
            if(min==a) a1++;
            if(min==b) b1++;
            if(min==c) c1++;
        }
        return number[n];
    }
}

