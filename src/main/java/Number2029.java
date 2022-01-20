import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/*
* 石子题目：
* alice 获胜为true,bob获胜为false;alice先手
*
* 获胜的情况：
* 1. 移除石子，总和可以被3整除，那么移除者获胜
* 2. 移除石子，总和不可以被3整除，并且没有石子，则bob获胜
*
* 每位选手：
* 1. 确保自己拿到的石头，使得总和不可以被3整除
* 2. 确保自己拿到的石头之后，总和对方可以选择一个被3整除
* 3. 最后，如果没有返回，返回最后总和，并判断胜利或者失败
* 利用贪心：每次选择一个离3最小的且不为0的数。
* */
// 卡bug:[19,2,17,20,7,17] false:应该为true;
public class Number2029 {
    Queue<Integer> zero,one,two;
    public boolean stoneGameIX(int[] stones) {
        int sum=0;
        zero=new ArrayDeque<>();
        one=new ArrayDeque<>();
        two=new ArrayDeque<>();
        for(int stone:stones){
            if(stone%3==0) zero.add(stone);
            else if(stone%3==1) one.add(stone);
            else two.add(stone);
        }
        while(true){
            int alice=choose(sum);
            if(alice==-1){
                return sum%3==0?true:false;
            }else{
                sum+=alice;
                if(sum%3==0) return true;
            }
            int bob=choose(sum);
            if(bob==-1){
                return sum%3==0?true:false;
            }else{
                sum+=bob;
                if(sum%3==0) return false;
            }
        }
    }
    public int choose(int sum){
        if(sum%3==0){
            if(!two.isEmpty()) return two.remove();
            else if(!one.isEmpty()) return one.remove();
            else if(!zero.isEmpty()) return zero.remove();
            else return -1;
        }else if(sum%3==1){
            if(!zero.isEmpty()) return zero.remove();
            else if(!one.isEmpty()) return one.remove();
            else if(!two.isEmpty()) return two.remove();
            else return -1;
        }else{
            if(!zero.isEmpty()) return zero.remove();
            else if(!two.isEmpty()) return two.remove();
            else if(!one.isEmpty()) return one.remove();
            else return -1;
        }
    }
    /*
    * 正确思路：分成0，1，2
    * 1的个数为0时或者2的个数为0时，：BOB胜
    * 1的个数>0并且2的个数>0的时候：Alice获胜
    * 但是存在奇数0的情况，此时会交换先后手顺序，也就是若bob移除的sum之和==0会换交给alice；
    * 但是若移除石子为最后一个，并且sum和不为0此时交换没有意义。
    * 也就是cnt2-cnt1>2则alice获胜，否则bob获胜。
    * */
    public boolean stoneGameIX1(int[] stones){
        int cnt0=0,cnt1=0,cnt2=0;
        for(int stone:stones){
            if(stone%3==0) cnt0++;
            else if(stone%3==1) cnt1++;
            else cnt2++;
        }
        if(cnt0%2==0){
            return cnt1>0&&cnt2>0;
        }
        return cnt1-cnt2>2||cnt2-cnt1>2;
    }
}
