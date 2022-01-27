import java.util.HashMap;
/*
* 求两数之和：
* 1.注意点：需要考虑比如target 6, 但是存在 3这个元素
*   因此要先查询，再放入数组。
* */
public class Number1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i]))  {
                return new int[]{hashMap.get(target-nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
