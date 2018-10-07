package leetcode;

import java.util.HashMap;
import java.util.Map;

public class T001_TwoSum {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i=0; i < nums.length-1; i++){
            for(int j=i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }


// time complexity : O(n^2)

//optimized solution:

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                res[0] = map.get(target - nums[i]);
                res[1] = i;
            }
            map.put(nums[i],i);
        }            
        return res;
    }
}

//TO LEARN:
// 1. map find the key: map.containsKey(xxx)
// 2. map get value: map.get(key)
// 3. map put new element: map.put(key, value)
