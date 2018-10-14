package leetcode;

public class T238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n];
        
        int left = 1;
        for(int i = 0; i < n; i++){
            res[i] = left;
            left *= nums[i];
        }
        
        int right = 1;
        for(int i = n-1; i >= 0; i--){
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}

/**
 * multiply the number from the left
 * 
 * then multiply the number from the right
 * 
 * 1 2 3 4
 * 
 * 24 12 8 6
 * 
 * For [1, 2, 3, 4]
 * Firstly calculate the product for ith element from left to right.
 * For res[i], left is the current accumulative product from its left side [0, i), then update left to left * nums[i].
 * Then calculate the product for ith elemenet from right to left. 
 * For res[i], mutiply with right, which is the accumulative product from its right side (i, nums.length-1],
 * then update right to right * nums[i].
 * 
 */

